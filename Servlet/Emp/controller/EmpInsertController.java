package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/insert")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Service 객체 생성
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/insert - GET 요청 완료");
		
		//VIEW 지정하기 및 응답하기(포워딩)
		req.getRequestDispatcher("/WEB-INF/views/emp/insert.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/insert - POST 요청 완료");
		
		//요청 파라미터 정보 얻기
		Emp emp = empService.getEmpParam(req);
		System.out.println("EmpInsertController - emp : " + emp);
		
		//DB에 사원 정보 추가하기
		empService.join(emp);
		
		//결과 화면 이동 - 목록 페이지로 이동
		resp.sendRedirect("/emp/list");
		
	}
}
