package singleton;

public class SingletonEx {
	public static void main(String[] args) {
		
		// private 생성자 호출 불가 - 객체 생성불가
		Singleton_01 s1= new Singleton_01();
		Singleton_01 s2= new Singleton_01();
		
		//두개가 같은 참조값을 가지는 것을 알 수 있다
		System.out.println(s1.getInstance());
		System.out.println(s2.getInstance());
		
		
		Singleton_02 s4 = Singleton_02.getInstance();
		Singleton_02 s5 = Singleton_02.getInstance();
		
		System.out.println(s4);
		System.out.println(s5);
		
		Singleton_03 s6 = Singleton_03.getInstance();
		Singleton_03 s7 = Singleton_03.getInstance();
		
		System.out.println(s6);
		System.out.println(s7);
	}
}
