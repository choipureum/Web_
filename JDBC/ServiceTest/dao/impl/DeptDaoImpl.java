package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao{
			//OJDBC 드라이버
			private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
			//DB 연결 정보
			private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";			
			private static final String USERNAME ="scott";
			private static final String PASSWORD ="tiger";
				
			//OJDBC 객체
			private static Connection conn=null; //DB연결 객체(접속객체) //ctrl+shift+o하면 임포트 해줌
			private static PreparedStatement ps=null; //SQL 수행객체 (Statement)와 기능은같지만 적용방식이 좀 다름
			//prepare를 사용하도록 한다
			private static ResultSet rs = null; //조회결과 반환 객체	
			//생성자
			public DeptDaoImpl() {			
				try {
					//드라이버 로드
					Class.forName(DRIVER);
					//DB연결
					conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				}					
			}
			
	@Override
	public List<Dept> selectAll() {
		
		String sql="";
		sql+="SELECT * FROM dept";
		sql+=" ORDER BY deptno";
		//쿼리 수행 결과 List
		List <Dept> deptList = new ArrayList<>();
		
		try {
			//쿼리 수행 객체 생성
			ps=conn.prepareStatement(sql);
			// 쿼리 수행
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Dept d= new Dept();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
				deptList.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//자원반납 => 2개만하기
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return deptList;
	}
	@Override
	public void insert(Dept dept) {
		int deptno=dept.getDeptno();
		String dname=dept.getDname();
		String loc=dept.getLoc();
		
		String sql="";
		sql+="INSERT INTO dept VALUES(?,?,?)";
		try {
			//쿼리 수행 객체 생성
			ps=conn.prepareStatement(sql);
			ps.setLong(1,deptno);
			ps.setString(2,dname);
			ps.setString(3,loc);
			// 쿼리 수행
			ps.executeUpdate();
			//커밋
			conn.commit();
			//롤백 - 잘못된 동작(SQL 수행 중 예외 발생)
//			try {
//				conn.rollback();
//			}catch(SQLException e1){
//				e1.printStackTrace();
//			}
			System.out.println("행 삽입 완료되었습니다");
			
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
		try {
			//자원반납 	
			//sql을 커밋해주고 트랜잭션 종료됨
			if(ps!=null)ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
					
	}
}
