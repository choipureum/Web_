package service;

import java.sql.Connection;

import DBUtil.JDBCTemplate;
import dao.BoardDao;
import dto.Board;


public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public int insertBoard(Board board) {		
	
			   Connection conn = JDBCTemplate.getConnection();			   
			   int result = boardDao.insertBoard(conn, board);
			   
			   if(result > 0) { 
			      JDBCTemplate.commit(conn);			      
			   } else { 
			      JDBCTemplate.rollback(conn);			      
			   }			   			 
			   return result;
		}
	}

