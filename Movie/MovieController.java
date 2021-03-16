import java.util.*;


public class MovieController {	 
	private static MovieDao dao = MovieDao.getInstance();

	public static void main(String[] args) {
		ArrayList<Movie> movieList = dao.GetMovieInfo();
		for(Movie movie: movieList) {
			System.out.println(movie.toString());
		}
	}
	
	 
	
}
