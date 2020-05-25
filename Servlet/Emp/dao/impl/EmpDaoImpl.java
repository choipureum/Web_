package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dbutil.DBConn;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	//OJDBC 관력 객체
	private Connection conn = null; //DB연결객체
	private PreparedStatement ps = null; //SQL수행객체
	private ResultSet rs = null; //조회결과객체
	
	@Override
	public List<Emp> selectAll() {
		
		//DB연결
		conn = DBConn.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " ORDER BY empno";
		
		//쿼리 결과 저장할 List
		List<Emp> list = new ArrayList<>();
		
		try {
			//SQL 수행
			ps = conn.prepareStatement(sql); //SQL수행 객체 생성
			rs = ps.executeQuery(); //SQL수행 및 결과 반환
			
			//결과 처리
			while( rs.next() ) {
				Emp emp = new Emp(); //새로운 Emp 객체 생성
				
				//ResultSet에서 데이터를 꺼내 Emp객체에 삽입
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				//결과값 리스트에 담기
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}

	@Override
	public Emp selectByEmpno(Emp emp) {
		
		//DB연결
		conn = DBConn.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno = ?";
		
		//조회 결과가 저장될 DTO
		Emp result = null;
		
		try {
			//SQL 수행
			ps = conn.prepareStatement(sql); //SQL수행 객체 생성
			
			ps.setInt(1, emp.getEmpno()); //조회될 사원번호 적용
			
			rs = ps.executeQuery(); //SQL수행 및 결과 반환
			
			//결과 처리
			while( rs.next() ) {
				result = new Emp();
				
				//ResultSet에서 데이터를 꺼내 Emp객체에 삽입
				result.setEmpno( rs.getInt("empno") );
				result.setEname( rs.getString("ename") );
				result.setJob( rs.getString("job") );
				result.setMgr( rs.getInt("mgr") );
				result.setHiredate( rs.getDate("hiredate") );
				result.setSal( rs.getDouble("sal") );
				result.setComm( rs.getDouble("comm") );
				result.setDeptno( rs.getInt("deptno") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return result;
	}

	@Override
	public void insert(Emp emp) {
		
		//DB연결
		conn = DBConn.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)";
		sql += " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
		
		try {
			//SQL 수행
			ps = conn.prepareStatement(sql); //SQL수행 객체 생성
			
			//SQL쿼리에 ? 채우기
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getMgr());
			
			// PreparedStatement 의 setDate() 메소드는
			//java.sql.Date 를 입력 받는다
			
			// java.util.Date타입의 정보를 java.sql.Date로
			//변경해야함
			//	-> java.sql.Date(long millis) 생성자를 이용한다
			
			java.sql.Date d = new java.sql.Date( emp.getHiredate().getTime() );
			ps.setDate(5, d);
			
			ps.setDouble(6, emp.getSal());
			ps.setDouble(7, emp.getComm());
			ps.setInt(8, emp.getDeptno());
			
			ps.executeUpdate(); //SQL수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//자원 해제
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}







