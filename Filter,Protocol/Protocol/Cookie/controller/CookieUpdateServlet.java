package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/update")
public class CookieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie c1= new Cookie("ID","Boo");
		resp.addCookie(c1); //클라이언트에게 쿠키 전달하기
		
		Cookie c2= new Cookie("PASS","5678");
		resp.addCookie(c2);
		
		Cookie c3= new Cookie("NAME","POO");
		resp.addCookie(c3);
		
		req.getRequestDispatcher("/WEB-INF/views/cookie/update.jsp").forward(req, resp);
	}


}
