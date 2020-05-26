package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {
	/**
	 * 전달파라미터 추출(파싱)
	 * @param req - 요청 정보 객체
	 * @return Member - 전달파라미터를 담은 객체
	 */
	public Member getMemberParam(HttpServletRequest req);
	
	/**
	 * 전달된 정보를 이용하여 회원가입 처리
	 * 
	 * @param member - 클라이언트로부터 전달된 회원 정보 객체
	 * @return Member - DB에서 삽입완료된 회원 정보 객체
	 * 	(반환 객체에는 userno가 포함되어 잇어야한다)
	 */
	public Member join(Member member);
	
	
}
