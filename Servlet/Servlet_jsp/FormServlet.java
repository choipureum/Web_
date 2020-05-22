package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")	
public class FormServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      System.out.println("FormServlet / form.do - GET요청");
      
      //jsp 로 응답데이터 만들기 - view
      
      RequestDispatcher rd;
      rd= req.getRequestDispatcher("/WEB-INF/views/inputForm.jsp"); //jsp 파일 경로 넣어주는 곳
      
      //jsp를 이용한 응답보내기
      rd.forward(req, resp); //포워드, 포워딩 
      
   }
   
   
   @Override         //요청메소드에 있는거 URL , METHOD, PARAMETER
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      //요청 데이터의 한글 인코딩 UTF - 8 설정
      req.setCharacterEncoding("UTF-8");
      
      
      //응답 데이터의 형식을 설정하기
      resp.setContentType("text/html;charset=utf-8");
      
      
      System.out.println("FormServlet / form.do - POST 요청");
      
      //전달파라미터를 요청객체 req에서 꺼내기
      String uid = req.getParameter("uid"); //input 태그의 name 
      String upw = req.getParameter("upw");
      
      // 전달파라미터 확인( 콘솔 출력 )ㅒ
      System.out.println("FormServlet Post uid : "+ uid);
      System.out.println("FormServlet Post upw : "+ upw);
      
      //응답데이터 구성하기
      //   JSP 활용하지 않음
      //   Servlet 으로 직접 응답을 작성하기
      

      PrintWriter out = resp.getWriter();
      
      out.append("<hr>")
         .append("<h1>전달받은 데이터</h1>")
         .append("<hr>")
         .append("<h3>아이디: " +uid+"</h3>")
         .append("<h3>패스워드: "+upw+"</h3>");
      
   }
}
