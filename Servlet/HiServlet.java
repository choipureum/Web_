package hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HiServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 매개변수
		//	HttpServletRequest : HTTP 요청 정보 객체
		//	HttpServletResponse : HTTP 응답 정보 객체
		
		//응답 메세지의 형식을 알려주는 코드
		// -> html 문법의 text이며 한글인코딩은 UTF-8
		resp.setContentType("text/html;charset=utf8");
		
		resp.getWriter().println("<h1>우리가 직접 만든 서블릿!</h1>");
		resp.getWriter().println("<h3>hello java</h3>");
		
		System.out.println("콘솔확인용, 테스트용 스트림 출력");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("안녕하세요 최푸름입니다");
	}
}
