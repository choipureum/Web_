package service.impl;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.ParamData;
import service.face.FileService;

public class FileServiceImpl implements FileService{
	
	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {
		//전달파라미터를 저장할 DTO객체
		ParamData paramData = new ParamData();
		
		//응답객체 Content-Type 설정
		resp.setContentType("text/html; charset=utf-8"); 
		
		//응답객체 출력 스트림 얻기
		PrintWriter out =null;
		
		try {
			out=resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 파일 업로드 7단계
		// 1. 파일업로드 형태가 데이터가 맞는지 검사
		// 요청메세지 Content-Type이 multipart/form-data가 맞는지 확인한다
		//ServletFileUpload를 사용할때 commons 라이브러리께 맞는지 확인하고 사용하기
		boolean isMultipart =false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		//1-1 해당 인코딩이 아닐경우 처리 중단
		if(!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data가 아닙니다</h1>");
			out.append("<a href='/commons/fileupload'>업로드페이지로 이동</a>");
			return; // fileupload() 메소드 중단시키기
		}
		//1-2 여기이후부터는 정상적 처리
		//2 업로드된 파일을 처리하는 아이템팩토리 객체 생성
		// ItemFactory : 업로드된 데이터(FileItem)을 처리하는 방식을 설정하는 클래스 
		
		//FileItem : 클라이언트로부터 전송된 데이터를 객체화시킨 것
		
		// DiskFileItemFactory class : 하드디스크 기반(HDD)의 파일아이템 처리(API) 
			//-> 업로드된 파일을 디스크(HDD)에 임시 저장하고 나중에 처리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//3.업로드된 파일 아이템의 용량이 적당히 작으면 메모리에서 처리하도록 설정
		int maxMen= 1*1024*1024;// 1MB
		factory.setSizeThreshold(maxMen); //설정
		
		//4.파일용량이 적당히 크면 임시파일(HDD) 만들어서 처리하도록 설정 -> 임시파일 폴더 설정
		//	파일(java.io)
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp"); 
		File repository = new File(path); //임시 저장 폴더
		System.out.println("repository : "+repository);	//경로 테스트 
		factory.setRepository(repository);
		
		//5.업로드 허용 용량 기준을 넘지 않을 경우에만 파일업로드
		//	처리되도록 설정
		//	-> 기준을 넘으면 업로드 차단됨
		int maxFile = 10*1024*1024; //10MB
			
		
		
		
		//파일업로드 수행 객체 생성
		// DiskFileItemFactory 객체 이용해서 생성함
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(maxFile); //파일 업로드 용량제한 설정: 10MB
		
		//-------------파일업로드 준비 완료 ----------------------------
		
		//6. 업로드된 데이터 추출
		//	임시 파일 업로드도 같이 수행된다
		
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}	
		
		//7. 파싱된 요청정보 데이터 처리하기
		//	items리스트에 요청파라미터(파일포함)이 파싱되어 들어있음
		
		//요청정보의 3가지형태
		//	1. 빈파일(용량이 0인 파일)
		//	2. form-data(전달 파라미터)
		//	3. 파일
		
		//파일 아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		//@모든 요청정보 처리하는 반복문
		while(iter.hasNext()) {
			//요청정보 객체
			FileItem item = iter.next();
			
			//1) 빈파일에 대한처리
			if(item.getSize()<=0) {
				continue;
			}
			//2) form-data(전달파라미터)처리
			if(item.isFormField()) {
				//form-data(form field) 는 key-value쌍으로 전달됨
				
				//key는 item.getFieldName()으로 얻어옴
				//value는 item.getString()으로 얻어옴
				
				//** 전달값이 한글일 경우 인코딩 설정 방법 -> item.getString("UTF-8")을 사용한다
				// ** req.setCharacterEncoding("UTF-8")이 적용되지 않는다
				out.println("---<폼필드>---<br>");
				out.println("키 : "+item.getFieldName()+"<br>");
				try {
					out.println("값 : "+item.getString("UTF-8")+"<br>");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				//------------키값 에 따라 처리하는 방식-----------
				//키 값 꺼내기
				String key = item.getFieldName();
				if("title".equals(key)) {//전달파라미터 name = "title"
					try {
						paramData.setTitle(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("data1".equals(key)) {//전달파라미터 name = "data1"
					try {
						paramData.setData1(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("data2".equals(key)) {//전달파라미터 name= "data2"
					try {
						paramData.setData2(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}				
			// 3. 파일에 대한 처리
			if(!item.isFormField()) {
				//업로드된 파일을 처리하는 방식
				//파일을 웹서버의 로컬디스크에 저장
				// 파일의 정보를 DB에 기록해야 한다(이것을 사용- 더 많이 사용한다)
				
				//서버에 저장되는 파일명을 "년월일시분초밀리초.확장자"로 변경하기
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
				String rename = sdf.format(new Date());
				//확장자 
				String origin = item.getName(); //원본파일명
				String ext = origin.substring(origin.lastIndexOf(".")+1);
				
				//저장될 이름
				String stored = rename+"."+ext;
				System.out.println("[TEST] sotred file name : "+ stored);
				
				//실제 업로드 파일
				File up = new File(context.getRealPath("upload"), stored); //업로드될 폴더, 변환된  저장파일의 이름
				
				try {
					item.write(up); //실제 업로드(최종 결과 파일 생성)
					item.delete(); // 임시 파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}//if(!item.isFormField()) END
			
		}//while(iter.hasNext()) END
		System.out.println(paramData);
		
	}
}




















