package service.face;

import java.util.List;

import dto.Emp;

public interface EmpService {


	/**
	 * 사원목록 전체 조회
	 * @return List<Emp> - 조회된 사원의 전체 목록 리스트			
	 */
	public List<Emp> list();

}
