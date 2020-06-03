package controller;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/commons/filelist")
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("fileList/화면");
				
				FileService fileService = new FileServiceImpl();
				List<UploadFile> fileList = fileService.list();
				
				//확인
				for( UploadFile e : fileList ) {
					System.out.println( e );
				}
							
				req.setAttribute("list", fileList);				
				req.getRequestDispatcher("/WEB-INF/views/commons/list.jsp").forward(req, resp);
				
			}
	

	}
