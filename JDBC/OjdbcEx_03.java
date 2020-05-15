import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_03 {
	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	//DB 연결 정보
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME ="scott";
	private static final String PASSWORD ="tiger";
	
	//OJDBC 객체
	private static Connection conn=null; //DB연결 객체(접속객체) //ctrl+shift+o하면 임포트 해줌
	private static Statement st=null; //SQL 구문 저장 및 수행 객체
	private static PreparedStatement ps=null; //SQL 수행객체 (Statement)와 기능은같지만 적용방식이 좀 다름
	private static ResultSet rs = null; //조회결과 반환 객체	
	
	public static void main(String[] args) {
		
		//      -----드라이버 로드------
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//job을 바꿔가면서 사용해야 재사용성이 높다
		String job= "SALESMAN";
		
		//---SQL 작성----
		String sql = "";
		sql+="SELECT * FROM emp";		
		sql+=" WHERE job= '"+job+"'"; //'SALESMAN'위치를 자유롭게 다른 직업으로도 바꿀수있게 수행(작은 따옴표로  양옆에 넣어줘야된다)
		//sql+=" WHERE job= ?"; 으로 해주면 prepareStatement에서 ?를 job으로 바꿀수있다 나중에
		sql+=" ORDER BY empno";
		
		
		try {
			//DB 연결
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			//SQL 수행 객체
			// Statement 객체는 생성(createStatement())될때 
			//매개변수없음
			
			//execute 할 때 쿼리를 매개변수로 전달한다
			//	원래 실행코드	
//			st= conn.createStatement();
//			rs= st.executeQuery(sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, job); //?에 SALESMAN이 'SALESMAN'으로 들어감
			rs=ps.executeQuery();
			
			int cnt=0;
			while(rs.next()) { //다음 행이 존재하면 true 반환하는 메소드	
				cnt++;
				System.out.print(rs.getString("empno")+","); 										
			}		
			System.out.println(cnt+"명입니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//자원 반납하기 
				finally {
					try {
						if(rs!=null)rs.close();
						if(st!=null)st.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
	}
}


