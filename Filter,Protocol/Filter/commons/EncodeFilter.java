package commons;

import java.io.IOException;

import javax.servlet.Filter; //Servlet 필터 임포트
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{
	
	//인코딩 설정값 변수
	private String charset =null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터클래스 초기화
		
		//web.xml에서 <init-param>변수값 얻어오기
		charset = filterConfig.getInitParameter("enc");
		
		//이것도 사용가능
		System.out.println(filterConfig.getInitParameter("htmlEnc"));
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//요청 전, 후 필터링처리
		System.out.println("EncodeFilter-doFilter()");
		System.out.println("doFilter()호출전");
		
		//한글 인코딩 설정하기
		// 1. POST 요청 정보 인코딩 설정
		req.setCharacterEncoding(charset);
		// 2. 응답데이터 ContentType 설정
		resp.setContentType("text/html;charset="+charset);
	
		
		//컨트롤러로 요청처리를 보내는 코드
		chain.doFilter(req, resp);
		System.out.println("doFilter()호출후");
	}
	
	@Override
	public void destroy() {
		
	}
}
