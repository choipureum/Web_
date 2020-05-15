import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;

public class OjdbcEx_04 {
		//OJDBC 드라이버
		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		//DB 연결 정보
		private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
		private static final String USERNAME ="scott";
		private static final String PASSWORD ="tiger";
		
		//OJDBC 객체
		private static Connection conn=null; //DB연결 객체(접속객체) //ctrl+shift+o하면 임포트 해줌
//		private static Statement st=null; 이제 안사용한다
		private static PreparedStatement ps=null; //SQL 수행객체 (Statement)와 기능은같지만 적용방식이 좀 다름
		//prepare를 사용하도록 한다
		private static ResultSet rs = null; //조회결과 반환 객체	
		
		
	public static void main(String[] args) {
		//전체 조회 결과를 저장할 리스트
		//	제네릭으로 처리
		List <Emp>list = new ArrayList<>();
		
//      -----드라이버 로드------
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//---SQL 작성----
		String sql = "";
		sql+="SELECT * FROM emp";				
		sql+=" WHERE job= ?"; 
		sql+=" ORDER BY empno";
		
		
		try {
			String job= "MANAGER";
			//DB 연결
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
								
			ps = conn.prepareStatement(sql);
			ps.setString(1, job); //?에 SALESMAN이 'SALESMAN'으로 들어감
			rs=ps.executeQuery();
			
			// 결과 처리				
			while(rs.next()) { //다음 행이 존재하면 true 반환하는 메소드					
				//새로운 빈 Emp 객체생성
				Emp emp = new Emp();
				//ResultSet 에서 Emp객체에 데이터 담기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				//앞에서 선언한 리스트에 emp객체 담기
				list.add(emp);				
			}
			for(Emp e:list) {
				System.out.println(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//자원 반납하기 
				finally {
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
	}
}
