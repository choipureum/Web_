package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.UserDao;
import dto.User;

public class UserDaoImpl implements UserDao {

	//OJDBC 드라이버
	private static final String DRIVER
	= "oracle.jdbc.driver.OracleDriver";
	
	//DB연결 정보
	private static final String URL
	= "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC 객체
	private static Connection conn = null; //DB연결객체
	private static PreparedStatement ps = null; //SQL수행객체
	private static ResultSet rs = null; //조회결과객체
	
	// 생성자
	public UserDaoImpl() {
		try {
			//----- 드라이버 로드 -----
			Class.forName(DRIVER);
			//-------------------------

			//----- DB 연결 -----
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//-------------------
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<User> selectAll() {		
		//----- SQL 작성 -----
		String sql = "";
		sql += "SELECT * FROM usertest";
		sql += " ORDER BY idx";
		//--------------------
		
		//----- 쿼리 결과 List -----
		List<User> userList = new ArrayList<>();
		//--------------------------
		
		try {
			//----- PreparedStatement 처리 -----
			ps = conn.prepareStatement(sql);//쿼리 수행 객체
			rs = ps.executeQuery(); //쿼리 수행 -> ResultSet에 저장
			//----------------------------------
			
			//----- ResultSet 처리 -----
			while( rs.next() ) { //결과값을 마지막까지 한 행씩 반복
				User user = new User(); //빈 User 객체 생성
				
				//한 행의 정보를 User객체에 삽입
				user.setIdx( rs.getInt("idx") );
				user.setUserid( rs.getString("userid") );
				user.setName( rs.getString("name") );
				
				//각 행의 정보를 전체 List에 삽입
				userList.add(user);
			}
			//--------------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//----- 자원해제 -----
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//--------------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userList;
	}

	@Override
	public void insertUser(User insertUser) {
		//--- SQL 작성 ---
		String sql = "";
		sql += "INSERT INTO userTest( idx, userid, name )";
		sql += " VALUES (userTest_SQ.nextval, ?, ?)";
		//----------------
		
		try {
			//--- PreparedStatement 처리 ---
			ps = conn.prepareStatement(sql);//쿼리수행객체
			
			// sql의 ? 채우기
			ps.setString(1, insertUser.getUserid()); //첫번째 ? 채우기
			ps.setString(2, insertUser.getName()); //두번째 ? 채우기
			
			ps.executeUpdate();//쿼리수행
			//------------------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteByIdx(int deleteIdx) {
		//--- SQL 작성 ---
		String sql = "";
		sql += "DELETE usertest";
		sql += " WHERE idx = ?";
		//----------------
		
		try {
			//--- PreparedStatement 처리 ---
			ps = conn.prepareStatement(sql);//쿼리수행객체
			
			ps.setInt(1, deleteIdx);
			
			ps.executeUpdate();//쿼리수행
			//------------------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User selectByIdx(int selectIdx) {
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT * FROM usertest";
		sql += " WHERE idx = ?";
		//----------------
		
		//--- 쿼리 결과 User ---
		User user = null;
		//----------------------
		
		try {
			//--- PreparedStatement 처리 ---
			ps = conn.prepareStatement(sql);//쿼리수행객체
			
			ps.setInt(1, selectIdx);
			
			rs = ps.executeQuery();//쿼리수행
			//------------------------------
			
			//--- ResultSet 처리 ---
			while(rs.next()) {
				user = new User();
				
				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//결과 반환
		return user;
	}

}
