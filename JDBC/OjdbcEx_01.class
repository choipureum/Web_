import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//JDBC 사용방법
//1. JDBC 드라이버 로드
//2. DB 접속(연결, Connection)
//3. SQL 쿼리 수행
//4. 조회된 결과 처리 
//5. 연결종료

public class OjdbcEx_01 {
	public static void main(String[] args) {		 
		
		//1. JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//----------OJDBC 사용에 필요한 변수들---------------
		Connection conn=null; //DB연결 객체(접속객체) //ctrl+shift+o하면 임포트 해줌
		Statement st=null; //SQL 구문 저장 및 수행 객체
		ResultSet rs = null; //조회결과 반환 객체				
		//----------------------------------------------
		//String url, id, pw적기
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			//3. SQL 쿼리 수행
				//3.1 쿼리 수행 객체 생성
			st= conn.createStatement();
									
			//3.2 SQL 수행 및 결과 저장(ResultSet)
				rs=st.executeQuery("SELECT * FROM emp ORDER BY empno");
			
				//조회된 행이 존재하는 만큼 반복하는 코드
				while(rs.next()) { //다음 행이 존재하면 true 반환하는 메소드
					//rs.next()를 한번 수행할 때마다 조회된 행을
					// 순차적으로 참조한다
					System.out.print(rs.getString("ename")+","); //컬럼명만 넣어야함 \n같은거 안됨	
					
					if(rs.getRow()==15) {
						System.out.println("\n---15번째 직원 월급---");
						System.out.println(rs.getString("SAL")); //열				
					}										
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		//자원 반납하기 
		finally {
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
}
