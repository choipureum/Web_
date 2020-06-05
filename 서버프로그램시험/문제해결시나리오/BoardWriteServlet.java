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

import dto.Board;

import service.BoardService;


@WebServlet("/binsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

			// 게시글 원글 등록 처리용 컨트롤러
			//request.setCharacterEncoding("utf-8");
			// 업로드할 파일의 용량 제한 : 10Mbyte로 제한한다면
			int maxSize = 1024 * 1024 * 10;
			RequestDispatcher view = null;

			// enctype="multipart/form-data" 로 전송되었는지 확인
			if (!ServletFileUpload.isMultipartContent(request)) {
        view = request.getRequestDispatcher("views/board/boardError.jsp");
        request.setAttribute("message", "form enctype 속성 사용 안 됨!");
		  	view.forward(request, response);
			}

			// 해당 컨테이너의 구동중인 웹 애플리케이션의 루트 경로 알아냄
			String root = request.getSession().getServletContext().getRealPath("/");
			// 업로드되는 파일이 저장될 폴더명과 경로 연결 처리
			String savePath = root + "files/board";
			// web/board_upload 로 지정함
			// request 를 MultipartRequest 객체로 변환함

			MultipartRequest mrequest = new MultipartRequest(
		    	request, savePath, maxSize, "UTF-8",
		    	new DefaultFileRenamePolicy());

			Board b = new Board();

			b.setBoardTitle(mrequest.getParameter("btitle"));
			b.setBoardContent(mrequest.getParameter("bcontent"));
			b.setBoardWriter(mrequest.getParameter("bwriter"));

			String originFileName = mrequest.getFilesystemName("upfile");

			if (originFileName != null) {
	  		// 업로도된 파일명을 "년월일시분초.확장자" 로 변경함
	  		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	  		String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
	  		+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

		  	// 파일명 바꾸기하려면 File 객체의 renameTo() 사용함
		  	File originFile = new File(savePath + "\\" + originFileName);
		  	File renameFile = new File(savePath + "\\" + renameFileName);

			// 파일이름 바꾸기 실행 >> 실패할 경우 직접 바꾸기함
			// 새 파일만들고 원래 파일내용 읽어서 복사 기록하고
			// 원 파일 삭제함

			if (!originFile.renameTo(renameFile)) {
			  int read = -1;
		  	byte[] buf = new byte[1024];

			// 한번에 읽을 배열 크기 지정
			FileInputStream fin = new FileInputStream(originFile);
			FileOutputStream fout = new FileOutputStream(renameFile);
      
			while ((read = fin.read(buf, 0, buf.length)) != -1) {
		  	fout.write(buf, 0, read);
			}

			fin.close();
			fout.close();

			originFile.delete(); // 원본 파일 삭제함

		}
			b.setBoardOriginalFileName(originFileName);
			b.setBoardRenameFileName(renameFileName);
			}

		 	response.setContentType("text/html; charset=utf-8");

		 	if (new BoardService().insertBoard(b) > 0) {
			  response.sendRedirect("/first/blist?page=1");

			} else {
			  view = request.getRequestDispatcher("views/board/boardError.jsp");
			  request.setAttribute("message", "게시 원글 등록 서비스 실패!");
		  	view.forward(request, response);

			}

			}
}
