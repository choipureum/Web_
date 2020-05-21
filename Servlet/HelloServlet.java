package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localhost8888/hello ->서블릿 경로
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서블릿을 바로 생성해도 되고 파일을 만들고 직접 상속받아서 작성해도 문제없음
	//do get만있어도 괜츈
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/hello 접속완");
		
		//응답 데이터 형식 지정
		response.setContentType("text/html;charset=utf-8");
		//응답 출력 스트림
		PrintWriter out = response.getWriter();
		
		//응답 내용 출력 (HTML형식)
		out.append("<h1>하이하이</h1>").append("<h3>잘되나요오?</h3>");
	}
}
