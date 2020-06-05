package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dto.Board;

import service.BoardService;


@WebServlet("/binsert")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/blist/list.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(req)) {	
			req.setAttribute("message", "form의 enctype 속성이 안맞습니다");
			req.getRequestDispatcher("/WEB-INF/views/commons/error.jsp").forward(req, resp);		
		}
		
	
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("board_upfiles");
		int maxPostSize = 10*1024*1024;
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		

		MultipartRequest mul = new MultipartRequest(
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String rename = sdf.format(new Date()); 
	
		String origin = mul.getOriginalFileName("upfile"); 
		String ext = origin.substring(origin.lastIndexOf(".")+1);
		
		String stored = rename+"."+ext;
		
		
		
		File originFile = new File(saveDirectory, origin);
		
		File renameFile = new File(saveDirectory,stored);
		originFile.renameTo(renameFile); //이름바꾸기
        
		//**Board 내용물 채우기 **
        Board board = new Board();
        //board 기본 내용물 채워서 전달
        board.setBoard_writer(req.getParameter("bwriter"));
        board.setBoard_title(req.getParameter("btitle"));       
        board.setBoard_content(req.getParameter("bcontent"));
        
               
        //파일 내용물 채우기
        board.setBoard_original_filename(origin);
        board.setBoard_rename_filename(stored);
        
        
        
        int res = boardService.insertBoard(board);
        // -------------------------------------------------------
   
        if( res > 0) {
           //insert 성공
           resp.sendRedirect("/blist");
           
        } else {
           //insert 실패
           req.setAttribute("message", "파일업로드 실패");
           req.getRequestDispatcher("/WEB-INF/views/commons/error.jsp")
              .forward(req, resp);
           
        }
		
	}
}
