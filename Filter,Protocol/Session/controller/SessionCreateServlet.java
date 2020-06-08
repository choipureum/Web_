package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/create")
public class SessionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// SESSION_ID 는 톰캣이 알아서 생성함
		
		// 세션 정보만 생성해서 처리하면 된다
		
		HttpSession session = request.getSession(); //세션 객체 생성
		
		session.setAttribute("test", "Apple"); //세션 정보 저장
		
		//세션 유지시간 변경하기(실제 코드에서 절대 사용 하지 말기!)-30분이 보통
//		session.setMaxInactiveInterval(0); //0초  == 무제한
		session.setMaxInactiveInterval(5); //-5초
		//VIEW 지정 - forward
		request.getRequestDispatcher("/WEB-INF/views/session/create.jsp")
			.forward(request, response);
		
	}

}










