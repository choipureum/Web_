package service.impl;

import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService{

	// EmpDao 생성
	private EmpDao empDao = new EmpDaoImpl();
	@Override
	public List<Emp> list() {
		
		//EMP 테이블,DB조회 결과 얻어오기 -DAO이용
		List<Emp> empList=empDao.selectAll();
		
		
		
		//결과반환
		return empList;
	}
}
