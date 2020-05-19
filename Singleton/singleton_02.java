package singleton;

//단점 보완(해결)

//	1. 인스턴스를 생성할 때 추가 작업을 할 수 없다
//		-> 예외처리 불가


public class Singleton_02 {
	
	public String data = "Apple";
	
	//private 생성자 - 클래스 외부에서 객체 생성하지 못하게 막는다
	public Singleton_02() {}
	
	
	private static Singleton_02 instance;
	//보완 부분 -static 블록
	// 클래스 변수(정적변수)를 초기화하는 블록
	static {
		try {
			instance = new Singleton_02(); //객체생성
			//멤버필드 생성과 동시에 초기화, 생성자에서 초기화와 기능이 비슷하다
			//위에 쓴것과 차이 : 생성자 안에 적으면 예외처리가 가능하다
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//싱글톤 객체 반환 메소드
	public static Singleton_02 getInstance() {
		return instance;
	}
}
