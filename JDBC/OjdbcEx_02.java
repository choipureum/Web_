import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_02 {
	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	//DB 연결 정보
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME ="scott";
	private static final String PASSWORD ="tiger";
	
	//OJDBC 객체
	private static Connection conn=null; //DB연결 객체(접속객체) //ctrl+shift+o하면 임포트 해줌
	private static Statement st=null; //SQL 구문 저장 및 수행 객체
	private static ResultSet rs = null; //조회결과 반환 객체	
	
	public static void main(String[] args) {
		
		//      -----드라이버 로드------
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//      -----SQL 작성-----
		String sql1 ="";
		sql1+="CREATE TABLE userTest(";
		sql1+="	idx NUMBER CONSTRAINT pk_user_test PRIMARY KEY,";
		sql1+="	name VARCHAR2(50) NOT NULL,";
		sql1+="	phone VARCHAR2(50) NOT NULL)";
		
		String sql2 ="";
		sql2+="CREATE SEQUENCE seq_usertest";
		sql2+="	INCREMENT BY 1";
		sql2+="	START WITH 1";
		//-------------------------------------
		try {
			//DB 연결
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			// SQL 수행
			st= conn.createStatement();			
			
			//----------생성 후 결과 처리---------------
			
			// 테이블 존재 여부 확인
			rs= st.executeQuery(
					"SELECT count(*) FROM tabs"
					+" WHERE table_name = upper('usertest')");
			
			//조회결과에서 첫번째 행 찾기
				//안해주면 에러
			rs.next();
			//1번째 인수값이 0보다 클때 (존재할때)
			System.out.println(rs.getInt(1)); //1 출력
			
			if(rs.getInt(1)>0) { //rs.getInt(count(*));
				System.out.println("테이블이 이미 존재합니다");
			}
			else {
				st.execute(sql1); //테이블 생성쿼리 수행
				
				System.out.println("테이블 생성 완료");
			}
			
			//시퀀스 존재 여부 확인
			rs= st.executeQuery("SELECT count(*) FROM user_sequences"
					+ "WHERE sequence_name=upper('seq_usertest')");
			
			rs.next();
			if(rs.getInt(1)>0) {
				System.out.println("시퀀스가 이미 존재합니다");
			}else {
				st.execute(sql2); //시퀀스 생성
				System.out.println("시퀀스 생성 완료");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}//자원 반납하기 
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
