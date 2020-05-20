package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Member;



public class MemberDao {
	private static PreparedStatement ps = null;
	private static ResultSet rs =null;
	
	/*
	 * 로그인 체크 
	 * */
	public Member loginCheck(Connection conn, String userid, String pwd) {
		String sql="SELECT * FROM member WHERE userid=? AND userpwd=?";
		Member member = null;
				
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2,pwd);
			rs= ps.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setUserId(rs.getString("userid"));
				member.setUserPwd(rs.getString("UserPwd"));
				member.setUserName(rs.getString("USerName"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setEnrollDate(rs.getDate("enrolldate"));
				member.setEtc(rs.getString("etc"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setLastModified(rs.getDate("lastmodified"));
				member.setPhone(rs.getString("phone"));				
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)rs.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return member;
	}//method end
	
	
	/*
	 * 존재X -멤버 삽입
	 * */
	public int insertMember(Connection conn,Member member) {
		//있는지 체크
		Member m_check=loginCheck(conn, member.getUserId(), member.getUserPwd());
		
		//존재하지않을때 1출력
		if(m_check==null) {
			String sql="INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			try {
				ps= conn.prepareStatement(sql);
				ps.setString(1,member.getUserId());
				ps.setString(2,member.getUserPwd());
				ps.setString(2,member.getUserName());
				ps.setString(3,member.getGender());
				ps.setInt(4,member.getAge());
				ps.setString(5,member.getPhone());
				ps.setString(6,member.getEmail());
				ps.setString(7,member.getHobby());
				ps.setString(8,member.getEtc());
				ps.setDate(9,member.getEnrollDate());
				ps.setDate(10,member.getLastModified());
				ps.setString(11,member.getUserId());
				ps.executeUpdate();								
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {				
					try {
						if(ps!=null)ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			//존재하지 않을때 1출력
			return 1;
		}
		else {
			//존재할때0출력
			return 0;
		}	
	}//method end
	
	/*
	 * 멤버제거
	 * */
	public int deleteMember(Connection conn,String userid) {
		//일단 멤버가 있는지 확인
			Member member_chk=selectOne(conn, userid);
			try {								
				//존재할때
				if(member_chk!=null) {
					String sql2 ="DELETE FROM member WHERE userid=?";
					ps=conn.prepareStatement(sql2);
					ps.setString(1, userid);
					ps.executeUpdate();
					return 1;
				}
				//존재하지 않을 때
				else {
					return 0;
				}				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				try {
					if(ps!=null)ps.close();					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return 0;		
		}//method end		
	
	/*
	 * userid같은 행 출력
	 * */
	public Member selectOne(Connection conn, String userid) {
		String sql="SELECT * FROM member WHERE userid=?";
		Member member = null;
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, userid);			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				member= new Member();
				member.setUserId(rs.getString("userid"));
				member.setUserPwd(rs.getString("UserPwd"));
				member.setUserName(rs.getString("USerName"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setEnrollDate(rs.getDate("enrolldate"));
				member.setEtc(rs.getString("etc"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setLastModified(rs.getDate("lastmodified"));
				member.setPhone(rs.getString("phone"));				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)rs.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return member;
	}//method end
	
	/*
	 *전부출력
	 * */
	public List<Member> selectAll(Connection conn){
		String sql="SELECT * FROM member order by userid";
	
		//담을 리스트 객체생성
		List <Member> list = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setUserId(rs.getString("userid"));
				member.setUserPwd(rs.getString("UserPwd"));
				member.setUserName(rs.getString("USerName"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setEnrollDate(rs.getDate("enrolldate"));
				member.setEtc(rs.getString("etc"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setLastModified(rs.getDate("lastmodified"));
				member.setPhone(rs.getString("phone"));
				//리스트 담기
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)rs.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return list;
	}//method end
}
