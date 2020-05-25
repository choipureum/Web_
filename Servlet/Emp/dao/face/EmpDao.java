package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * Emp테이블 전체 조회
	 * @return List<Emp> - 조회된 결과 리스트
	 */
	public List<Emp> selectAll();
	
	/**
	 * Emp테이블의 지정된 사원에 대한 상세정보 조회
	 * 
	 * @param emp - 지정된 사원의 empno가 들어있는 객체
	 * @return Emp - 조회된 사원 정보
	 * 		단, 예외가 발생하면 null값을 반환한다
	 */
	public Emp selectByEmpno(Emp emp);
	
	/**
	 * 사원 정보를 삽입
	 * @param emp - 삽입할 사원 정보
	 */
	public void insert(Emp emp);
}


