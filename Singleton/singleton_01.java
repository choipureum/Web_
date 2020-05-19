package singleton;

//단점
//	1. 인스턴스를 생성할 때 추가 작업을 할 수 없다
//		-> 예외처리 불가
//  2. 인스턴스(객체)를 사용하지 않아도 생성해 놓는다

public class Singleton_01 {
	
	public String data = "Apple";
	
	//private 생성자 - 클래스 외부에서 객체 생성하지 못하게 막는다
	public Singleton_01() {	}
	//자신 클래스에 대한 객체생성
	// static을 만들면 내부에서 사용가능하다
	private static Singleton_01 instance = new Singleton_01();
	
	//싱글톤 객체 반환 메소드
	public static Singleton_01 getInstance() {
		return instance;
	}
}
