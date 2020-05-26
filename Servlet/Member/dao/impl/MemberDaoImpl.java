package dao.impl;

import DButil.DBconn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.face.MemberDao;
import dto.Member;

public class MemberDaoImpl implements MemberDao{
	private static Connection conn=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	@Override
	public void insert(Member member) {
		String sql="INSERT INTO member VALUES(?,?,?,?)";
		conn= DBconn.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,member.getUserno());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getNick());
			ps.setString(4,member.getEmail());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {		
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}			
	}
	
	
	@Override
	public int selectNextUserno() {
		String sql="SELECT member_seq.nextval FROM dual";
		
		conn= DBconn.getConnection();
		int nextval =0; //조회된 시퀀스값
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			rs.next();
			nextval=rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
		return nextval;
	}
}
