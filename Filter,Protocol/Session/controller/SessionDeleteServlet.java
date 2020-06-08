package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/delete")
public class SessionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//속성값 제거
		session.removeAttribute("test");
		//모든 속성값 제거
		session.invalidate();
		
		//index.jsp로 이동-컨텍스트패스
//		response.sendRedirect(request.getContextPath());	
		request.getRequestDispatcher("/WEB-INF/views/session/delete.jsp").forward(request,response);
	}

}






