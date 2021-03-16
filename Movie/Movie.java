import java.util.*;

public class Movie {
	private String tit;
	private String tit2;
	private String age;
	private int rank;
	private String cate;
	
	// Getter
	public String getTit() {
	    return tit;
	}
	  
	// Setter
	public void setTit(String tit) {
	  this.tit = tit;
	}
	// Getter
	public String getTit2() {
		return tit2;
	}
		  
	// Setter
	public void setTit2(String tit2) {
		this.tit2 = tit2;
	}
	// Getter
	public String getAge() {
		return age;
	}
		  
	// Setter
	public void setAge(String age) {
		this.age = age;
	}
	// Getter
	public int getRank() {
		return rank;
	}
		  
	// Setter
	public void setRank(int rank) {
		this.rank = rank;
	}
	// Getter
	public String getCate() {
		return cate;
	}
		  
	// Setter
	public void setCate(String cate) {
		this.cate = cate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "----------\n타이틀:"+this.getTit2() +"\n"
				+"나이:"+this.getAge() +"\n"
				+"순위:"+this.getRank() +"\n"
				+"장르:"+this.getCate();
	}
	
	
}
