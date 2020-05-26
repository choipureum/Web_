package dao.face;

import java.util.List;

import dto.Member;

public interface MemberDao {
	
	public void insert(Member member);

	
	
	/**
	 * member_seq를 이용하여 다음 PK 로 사용될 userno를 조회한다
	 * 
	 * @return int - member_seq.nextval
	 */
	public int selectNextUserno();
	
	
}
