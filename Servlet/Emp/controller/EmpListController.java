package controller;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//접속 테스트
		System.out.println("/emp/list GET메소드 접속 성공");
		
		//Emp 테이블의 전체 목록 조회
		List<Emp> empList = empService.list();
		//[TEST] 조회 결과 출력- Console
		for(Emp e :empList) {
			System.out.println(e);
		}
		//View에 조회결과(Model)를 View에 전달
		
		//Jsp를 View로 지정하고 응답으로 사용하기 - 포워딩
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
