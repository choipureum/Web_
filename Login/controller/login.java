package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//userid, userpw 전달파라미터 변수처리하기 
		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");
		
		//포워딩될 URL(VIEW)
		String url=null;
		
		//세션 객체 생성
		HttpSession session = req.getSession();
		
		//로그인 인증(Authentication, auth)
		if("abc".equals(id) && "123".equals(pw)) {
			//로그인성공
			url="/WEB-INF/views/login/loginSuccess.jsp";
			
			session.setAttribute("login", true); //로그인 상태  login=true
			session.setAttribute("loginid",id ); // 로그인 아이디(패스워드는 안넣어도됨) ->PK만 넣어주면됨
		}
		else {
			//로그인 실패
			url="/WEB-INF/views/login/loginFail.jsp";
		}
		req.getRequestDispatcher(url).forward(req, resp);;

	}

}
