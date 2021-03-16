import java.util.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieDao{
	private static String url = "https://movie.naver.com/movie/running/current.nhn#";
	private static MovieDao movieDao;
	
	private MovieDao() {}
	
	public static MovieDao getInstance(){
		try {
			if(movieDao ==null) {
				movieDao = new MovieDao();
			}
			return movieDao;
		}
		catch(Exception e) {
			throw new RuntimeException("[Error: Create instance fail : "+  e.getMessage()+"]");
		}
	}
	
	
	public ArrayList<Movie> GetMovieInfo() {
		ArrayList<Movie>list = new ArrayList<Movie>();
		int idx=0;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new RuntimeException("[Error: Crawling fail : "+  e.getMessage()+"]");			
		}		
		Elements articles = doc.select("#content > div.article > div:nth-child(1) > div.lst_wrap > ul > li");
		for(Element element: articles) {
			Movie movie = new Movie();
			movie.setTit(element.select("dl > dt > span").text());
			movie.setTit2(element.select("dl > dt > a").text());
			movie.setAge(element.select("dl > dt > span").text());			
			String temp = element.select("dl.info_txt1").select("span").text();		
			movie.setCate(temp.substring(0,temp.indexOf("|")));
			//System.out.println(movie.getCate());
			movie.setRank(idx+1);
			idx++;
			list.add(movie);
		}
		return list;
	}

}
