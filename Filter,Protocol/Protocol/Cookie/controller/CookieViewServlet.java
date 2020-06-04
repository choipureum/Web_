package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/view")
public class CookieViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//쿠키 정보 전체 가져오기(Cookie[])
		Cookie[] cookies=req.getCookies();
		
		for(Cookie c : cookies) {
			System.out.println(c); //참조값으로 출력됨
			System.out.println(c.getName()+"="+c.getValue());
		}
		
		req.getRequestDispatcher("/WEB-INF/views/cookie/view.jsp").forward(req, resp);
	}
	

}
