package session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/view")
public class SessionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//세션 객체 얻기
		HttpSession session = request.getSession();
		
		//세션 정보 출력
		System.out.println("test : " + session.getAttribute("test"));
		
		System.out.println("--------세션 관련 정보----------");
		
		//세션 아이디
		System.out.println("Session ID : "+session.getId());
		//세션 생성시간(new Date로 우리가 알수있는 시간으로 변환해줌)
		System.out.println("CreationTime : "+new Date(session.getCreationTime()));
		
		//세션 최근(마지막) 접속 시간
		System.out.println("LastAccessedTime : "+ new Date(session.getLastAccessedTime()));
		//세션 유지 시간
		System.out.println("MaxInactiveInterval : "+ session.getMaxInactiveInterval());
		//세션이 새롭게 생성된 것인지 판단
		System.out.println("isNem : "+session.isNew());
		
		
		
		
		
		
		//VIEW 지정 - forward
		request.getRequestDispatcher("/WEB-INF/views/session/view.jsp")
			.forward(request, response);

		
	}

}








