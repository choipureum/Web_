package dao.face;

import java.util.List;

import dto.User;

public interface UserDao {

	// 추상메소드 - 구현할 메소드의 기본 형식
	
	/**
	 * 전체 조회
	 * 
	 * @return List<User> - 전체조회된 결과 리스트
	 */
	public List<User> selectAll();
	
	/**
	 * 데이터 삽입
	 * 
	 * @param insertUser - 삽입하려는 객체
	 */
	public void insertUser(User insertUser);
	
	/**
	 * 데이터 조회
	 * 
	 * @param idx - 조회하려는 유저의 idx 번호
	 * @return User - 조회된 사용자 정보
	 */
	public User selectByIdx(int idx);
	
	/**
	 * 데이터 삭제
	 * 
	 * @param idx - 삭제하려는 사용자의 idx
	 */
	public void deleteByIdx(int idx);
}
