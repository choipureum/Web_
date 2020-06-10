package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Member;

@WebServlet("/ajax/test2")
public class AjaxTestController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/ajax/test2.jsp").forward(req, resp);
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Member> list = new ArrayList<>();
		
		Member member1 = new Member();
		member1.setId("Apple");
		member1.setPw("12345");
		list.add(member1);
		
		Member member2 = new Member();
		member2.setId("Grape");
		member2.setPw("12345");
		list.add(member2);
		
		Member member3 = new Member();
		member3.setId("Mango");
		member3.setPw("12345");
		list.add(member3);
		
		req.setAttribute("list", list);
		
		//VIEW 지정 -  forward
		req.getRequestDispatcher("/WEB-INF/views/ajax/result.jsp").forward(req, resp);
																			
		
	}

}
