package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//싱글톤 적용 객체 -DB연결
// 	Connerction 객체를 하나만 만들어서 사용할 수 있게 만든다

public class DBconn {
	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	//DB 연결 정보
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";			
	private static final String USERNAME ="scott";
	private static final String PASSWORD ="tiger";
		
	//OJDBC 객체
	private static Connection conn=null; //DB연결 객체(접속객체) //ctrl+shift+o하면 임포트 해줌
	//실행 부분은 싱글톤이 적용되면 안된다
	
//	private static PreparedStatement ps=null; //SQL 수행객체 (Statement)와 기능은같지만 적용방식이 좀 다름
//	//prepare를 사용하도록 한다
//	private static ResultSet rs = null; //조회결과 반환 객체	
	
	//private 생성자 - 외부에서 객체 생성하는 걸 막는용도
	private DBconn() {}
	
	//Connection 객체 반환 - 싱글톤 패턴 적용 메소드
	public static Connection getConnection() {
		if(conn==null) {
			try {
				Class.forName(DRIVER);
				conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}			
		}		
		return conn;		
	}
	
	}



