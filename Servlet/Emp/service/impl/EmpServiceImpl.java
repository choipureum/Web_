package service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService {

	//EmpDao 객체 생성
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public List<Emp> list() {
		
		//EMP테이블, DB 조회 결과 얻어오기 - Dao 이용
		List<Emp> empList = empDao.selectAll();
		
		//결과 반환
		return empList;
	}

	@Override
	public Emp detail(Emp emp) {
		return empDao.selectByEmpno(emp);
	}

	@Override
	public Emp getEmpParam(HttpServletRequest req) {
		
		//빈 Emp 객체 생성
		Emp emp = new Emp();
		
		//empno - NUMBER(4,0)
		String param = req.getParameter("empno");
		if(param!=null && !"".equals(param)) {
			emp.setEmpno( Integer.parseInt(param) );
		}

		//ename - VARCHAR2(10)
		emp.setEname( req.getParameter("ename") );
		
		//job - VARCHAR2(9)
		emp.setJob( req.getParameter("job") );
		
		//mgr - NUMBER(4,0)
		param = req.getParameter("mgr");
		if(param!=null && !"".equals(param)) {
			emp.setMgr( Integer.parseInt(param) );
		}
		
		//hiredate - DATE
		param = req.getParameter("hiredate");
		if(param!=null && !"".equals(param)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				emp.setHiredate( format.parse(param) );
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//sal - NUMBER(7,2)
		param = req.getParameter("sal");
		if(param!=null && !"".equals(param)) {
			emp.setSal( Double.parseDouble(param) );
		}
		
		//comm - NUMBER(7,2)
		param = req.getParameter("comm");
		if(param!=null && !"".equals(param)) {
			emp.setComm( Double.parseDouble(param) );
		}
		
		//deptno - NUMBER(2,0)
		param = req.getParameter("deptno");
		if(param!=null && !"".equals(param)) {
			emp.setDeptno( Integer.parseInt(param) );
		}
		return emp;
	}

	@Override
	public void join(Emp emp) {
		
		//DAO를 통해 사원정보 삽입
		empDao.insert(emp);
		
	}

}
