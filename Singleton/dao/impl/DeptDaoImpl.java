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
	private static PreparedStatement ps=null; 
	private static ResultSet rs = null; 
		@Override
			public Dept selectOne(Connection conn, int deptno) {
				Dept dept=null;
				String sql="";
				sql+="SELECT * FROM dept where deptno=?";
				
				try {
					ps= conn.prepareStatement(sql);
					ps.setLong(1, deptno);					
					rs=ps.executeQuery();
					
					while(rs.next()) {
						dept= new Dept();
						dept.setDeptno(rs.getInt("deptno"));
						dept.setDname(rs.getString("dname"));
						dept.setLoc(rs.getString("loc"));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		
				return dept;
			}	
}




