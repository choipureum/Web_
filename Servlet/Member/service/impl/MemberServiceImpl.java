package service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member getMemberParam(HttpServletRequest req) {
		Member member = new Member();		
		//userno - 
		//사용자가 전달하는 값이 아님 - DB에서 member_seq를 이용해 생성하는 값
		member.setUserid(req.getParameter("userid"));		
		member.setNick(req.getParameter("nick"));		
		member.setEmail(req.getParameter("email"));			
		return member;
	}@Override
	public Member join(Member member) {
		//1. member_seq의 다음 nextval 값을 조회하기
		//MemberDao이용
		//SELECT member_seq.nextval FROM dual;
		int next = memberDao.selectNextUserno();
		System.out.println("next : "+ next);
		//2. 얻어온 시퀀스 값을 member객체에 대입
		member.setUserno(next);
		//3. member객체를 DB에 insert
		memberDao.insert(member);
		//4.  member객체 반환		
		return member;
	}
	
	
}
