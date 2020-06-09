package gson;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.person;

@WebServlet("/gson02")
public class gsonTest_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		Gson gson =new Gson();
		
		person p1 =new person();
		
		//p1객체를 json으로 마샬링
		String jsonText = gson.toJson(p1);
		System.out.println(jsonText);
		
		//person으로 다시 언마샬링
		String test="{\"name\":\"Alice\",\"age\":20,\"addr\":\"Seoul\"}";
		person p2= gson.fromJson(test, person.class);
		
		HashMap<String,Object> map = new HashMap<>();
		
		map.put("name","Bob");
		map.put("age",30);
		map.put("addr","Busan");
		map.put("phone","12345676");
		
		map.put("p", new person());
		
		
		
		
	}


}
