package service.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {

	/**
	 * 파일 업로드 
	 * Commons-Fileupload 라이브러리활용
	 * @param req - 요청정보객체
	 * @param resp - 응답정보 객체
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
		
	public List<UploadFile> list();
	/**
	    * 업로드된 파일 정보 기록하기
	    * 
	    * @param up - 업로드된 파일의 정보
	    * @return int - DB에 insert수행한 결과
	    *    0 - insert실패
	    *  1 - insert성공
	    */
	   public int insertFile(UploadFile up);
}
