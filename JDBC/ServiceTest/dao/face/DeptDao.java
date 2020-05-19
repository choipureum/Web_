package dao.face;

import java.util.List;

import dto.Dept;

public interface DeptDao {
	/*
	 * Dept 테이블 전체조화
	 * @return List<Dept> - 조회된 전체 행
	 * */
	public List <Dept> selectAll();
	
	/*
	 * 신규 부서 정보 입력
	 * @param dept - 새롭게 입력되 부서 정보
	 * */
	public void insert(Dept dept);
}

//ctrl+shift+s =>전체 저장
//ctrl+shift+o =>전체 임포트 
