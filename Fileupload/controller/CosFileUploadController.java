package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/cos/fileupload")
public class CosFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileService fileService = new FileServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/cos/fileupload.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//enctype ="multipart/form-data" 검증
		if(!ServletFileUpload.isMultipartContent(req)) {
			req.setAttribute("message", "form의 enctype 속성이 안맞습니다");
			//에러처리 전용 View(JSP)만들어서 응답
			req.getRequestDispatcher("/WEB-INF/views/file/error.jsp").forward(req, resp);		
			return; //doPost 메소드 중단시키기
		}
		
		//---매개변수 준비---
		//1. 요청 객체 -req
		//2. 파일 저장 위치
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");
		//3.업로드 제한 사이즈 -10MB
		int maxPostSize = 10*1024*1024;
		//4. 인코딩
		String encoding = "UTF-8";
		//5.  중복된 파일이름 처리할 정책
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		//** DefaultFileRenamePolicy
		//	이미 업로드된 파일 중에 같은 이름이 있으면 새롭게 업로드된
		//	파일이름 번호를 붙여준다
		
		// COS파일 업로드 객체생성
		MultipartRequest mul = new MultipartRequest(
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy);
		
		//** MultipartRequest 객체가 생성되면서 파일업로드 수행됨
		//--------------------------------------------------
		
		//업로드된 파일명을 변경해야한다 -> 이미 업로드했기때문
		
		//서버에 저장되는 파일명을 "년월일시분초밀리초.확장자"로 변경하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
		String rename = sdf.format(new Date()); //바꿀이름
		//확장자 
		String origin = mul.getOriginalFileName("upfile"); //원본파일명
		String ext = origin.substring(origin.lastIndexOf(".")+1);
		
		//저장될 이름
		String stored = rename+"."+ext;
		//---------------------------
		//1. 원본 File 객체를 생성
		//2. 바꿀 File 객체를 생성
		//3. 원본 File을 바꿀 File로 변경
		//	**java.io.File 객체를 활용한다
		
		//업로드된 원본파일 객체 생성
		File originFile = new File(saveDirectory, origin);
		
		//바꿀 파일 객체 생성
		File renameFile = new File(saveDirectory,stored);
		//파일 이름 바구기-java.io.File 객체의 메소드 활용
		originFile.renameTo(renameFile); //이름바꾸기
 // ---- 업로드된 파일의 정보를 DB에 기록하기 --------------------------
        
        UploadFile up = new UploadFile();
        
        up.setOriginName(origin);
        up.setStoredName(stored);
        
        int res = fileService.insertFile(up);
        // -------------------------------------------------------
   
        if( res > 0) {
           //insert 성공
           resp.sendRedirect("/commons/filelist");
           
        } else {
           //insert 실패
           req.setAttribute("message", "파일업로드 실패");
           req.getRequestDispatcher("/WEB-INF/views/file/error.jsp")
              .forward(req, resp);
           
        }
		
	}
}

