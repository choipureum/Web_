package Controller;
import java.util.*;

import dto.Dept;
import service.face.DeptService;
import service.impl.DeptServiceImpl;

public class DeptEx {
	//서비스 객체 -DeptService
	private static DeptService deptService = new DeptServiceImpl();
	
	public static void main(String[] args) {
		//
		//DeptService deptService = new DeptServiceImpl();
		//Dept 테이블의 모든 데이터 조회(list)
		List<Dept> list = deptService.deptList();
		
		//결과확인
		for(Dept d:list) {
			System.out.println(d);
		}
		//----------------------------------------
		Dept dept = new Dept();
		dept.setDeptno(87);
		dept.setDname("Test2");
		dept.setLoc("SEOUL");
		
		deptService.addDept(dept);
	}
}
