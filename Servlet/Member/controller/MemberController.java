package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberService memberService = new MemberServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       //접속테스트
       System.out.println("/member/join get 요청완료");
       
       //view 지정 응답하기(forward)
       req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp")
          .forward(req, resp);
       
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {      
       //접속테스트
       System.out.println("/member/join POST - 요청완료");
       //1.POST데이터 한글 인코딩 설정
       req.setCharacterEncoding("UTF-8");
       //2.요청 파라미터를 Member DTO에 저장하기
       	//service이용
       Member member = memberService.getMemberParam(req);
       System.out.println("member : " + member);
		
       //DB에 사원 정보 추가하기
       Member result=memberService.join(member);
		//DB에 입력된 객체를 VIEW 에 전달하기 -MODEL값
       	// request 객체 이용
       req.setAttribute("result", result);
       
       //view를 지정하고 응답하기(Forward)
       req.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(req, resp);
		
    }
}
