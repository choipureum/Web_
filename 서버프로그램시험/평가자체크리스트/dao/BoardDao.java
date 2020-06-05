package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.JDBCTemplate;
import dto.Board;


public class BoardDao {
	private static Connection conn=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	
	public int insertBoard(Connection conn, Board board) {
		
		conn= JDBCTemplate.getConnection();
		//디폴트 0 제외 나머지 삽입
		String sql="INSERT INTO Board(";
				sql+= " board_num,";
				sql+= " board_writer,";
				sql+= " board_title,";
				sql+= " board_content,";				
				sql+= " board_original_filename,"	;			
				sql+= " board_rename_filename)";
				sql+= " board_reply_seq";
				sql+= " VALUES(Board_seq_nextval,?,?,?,?,?,Board_reply_seq.nextval)";
		
		//res 출력스위치
		int res=0;
		// 쿼리문 getter로 받아서 실행
		try {			
			ps=conn.prepareStatement(sql);
			ps.setString(1, board.getBoard_writer());
			ps.setString(2, board.getBoard_title());
			ps.setString(3, board.getBoard_content());
			ps.setString(4, board.getBoard_original_filename());
			ps.setString(5, board.getBoard_rename_filename());			
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {		
			JDBCTemplate.close(ps);
		}
		return res;
	}
	
	
}
