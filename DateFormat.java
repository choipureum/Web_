package test;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class DateFormatEx {
	public static void main(String[] args) {
		
		//YYYY-MM-DD 형태로 받아지는 형태가 들어온다
		// 전달 파라미터 형식 String
		String param="2020--5-18";
		// String -> java.util.Date
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			Date d=format.parse(param);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//java.util.Date -> String (format함수 사용)
		String y=format.format(new Date()); //new Date() =현재시간
		System.out.println(y);
	}
}
