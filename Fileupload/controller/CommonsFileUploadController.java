package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.FileService;
import service.impl.FileServiceImpl;


@WebServlet("/commons/fileupload")
public class CommonsFileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//파일서비스 객체
	private FileService fileService = new FileServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		//VIEW 지정 - 파일업로드<form> 페이지 띄우기(포워드)
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);
	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Filiupload doPost 접속완료");
		
		//application/x-www-form-urlencoded 인코딩 방식으로 전달된 
		//요청 파라미터는 req.getParameter()메소드를 통해서 얻을수 있지만
	
		//multipart/form-data 인코딩 방식으로 전달된 요청파라미터는 req.getParameter()메소드에서 null만 반환된다
		
		//-> 파일 업로드 라이브러리를 활용해서 처리해야만 한다
		System.out.println("title : "+ req.getParameter("title"));
		System.out.println("data1 : "+req.getParameter("data1"));
		System.out.println("data2 : "+req.getParameter("data1"));
		System.out.println("upfile : "+req.getParameter("upfile"));
		
		//따라서 null값이 반환된다
		
		//서비스객체를 이용한 파일 업로드 처리
		fileService.fileupload(req,resp);
		
		//결과 페이지로 리다이렉트 - /file/list
		resp.sendRedirect("/commons/filelist");
	}

}

