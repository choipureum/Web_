package gson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/gson01")
public class gsonTest_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		
		//toJson() -> java데이터 -> Json text로 변환(마샬링)
		//fromJson() ->JSON Text -> Java데이터로 변환(언마샬링)
		
		//int형 데이터
		System.out.println(gson.toJson(123)); //json
		
		//String형 데이터
		System.out.println(gson.toJson("Apple"));
		
		//Long형 데이터
		System.out.println(gson.toJson(new Long(20))); //20
		System.out.println(gson.toJson(20L)); //Long형 상수 //20
		
		//ing형 [] 배열
		int[] arr = {1,2,3,4,5};
		System.out.println(arr); //참조값 출력
		
		int n1= gson.fromJson("123", int.class);
		
		//String형 데이터 언마샬링
		String str=gson.fromJson("Apple", String.class);
		
	
	}

}
