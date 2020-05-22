package dao.impl;

import java.util.ArrayList;
import java.util.List;

import DButil.DBconn;

import java.sql.*;
import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao{
	
	
	private Connection conn =null;
	private PreparedStatement ps =null;
	private ResultSet rs =null;
	
	@Override
	public List<Emp> selectAll() {
		
		//DB연결
		conn= DBconn.getConnection();
		//SQL 작성
		String sql="SELECT * FROM emp ORDER BY empno";
		//쿼리 수행하고 저장할 List
		List <Emp> list =new ArrayList<>();				
		//결과처리		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Emp emp= new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//자원해제
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}	
		//결과반환
		return list;
}
}






