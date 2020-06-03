package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.UploadFile;

public interface FileDao {
	
	/**
	 * 파일 업로드 정보 기록하기
	 * 
	 * @param uploadFile - 업로드한 파일의 정보
	 */
	 public void insert(UploadFile uploadFile);
	 
	 /**
	  * DB결과 조회
	  * @return List<UploadFile> - 조회결과
	  */
	 public List<UploadFile> selectAll();
	 /**
	    * 파일정보 DB에 insert 수행
	    * 
	    * @param conn - DB연결객체
	    * @param up - 업로드된 파일 정보
	    * @return int - insert 수행 결과
	    *    1 - insert 성공
	    *  0 - insert 실패
	    */
	 public int insertFile(Connection conn, UploadFile up);
}


