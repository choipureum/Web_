package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.face.FileDao;
import dbutil.JDBCTemplate;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {
	//OJDBC 관련 객체
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	@Override
	public  void insert(UploadFile uploadFile) {
		conn= JDBCTemplate.getConnection(); //DB연결
		//SQL 작성
		String sql ="INSERT INTO uploadfile VALUES(uploadfile_seq.nextval,?,?)";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getStoredName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
	}
	
	@Override
	public List<UploadFile> selectAll() {
		
		conn= JDBCTemplate.getConnection();
		
		String sql="SELECT * FROM uploadfile order by fileno";
		List<UploadFile> fileList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UploadFile uploadfile = new UploadFile();
				uploadfile.setFileno(rs.getInt("fileno"));
				uploadfile.setOriginName(rs.getString("origin_Name"));
				uploadfile.setStoredName(rs.getString("stored_Name"));
				fileList.add(uploadfile);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	
		return fileList;
	}
	@Override
	public int insertFile(Connection conn, UploadFile up) {
		conn = JDBCTemplate.getConnection();
		String sql="INSERT INTO uploadfile VALUES(uploadfile_seq.nextval,?,?)";
		
		//insert 변수를 저장할 변수
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, up.getOriginName());
			ps.setString(2, up.getStoredName());
			res=ps.executeUpdate(); //수행결과 저장
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}
}
