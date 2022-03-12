class Single{// Single이라는 클래스를 만듦 
	int i; 
	private static Single s = new Single(); // 자기 클래스 타입의 것 만듦 
	private Single() {
		i = 10;
		
	}
	public static Single getInstance() {
		return s;
	}
}
public class SingletonTest {
	public static void m1() {
		Single s1 = Single.getInstance();
		System.out.println("in m1: s1정보값=" + s1);
		s1.i = 99;
		
	}
	
	public static void m2() {
		Single s1 = Single.getInstance();
		System.out.println("in m2: s1정보값=" + s1);
		s1.i--;
		
	}

	public static void main(String[] args) {
		//new Single(); //아무런 생성자 만들지 않으면 default 생성자가 포함이 됨. 이것이 안되게 해야 함. 
		Single s1 = Single.getInstance();
		System.out.println(s1.i);// 10 
		System.out.println("in main: s1정보값=" + s1);
		m1(); //m1 호출
		System.out.println(s1.i);  //99
		m2(); 
		System.out.println(s1.i);  //98  같은 메모리를 참조한다. 효율성을 위해서 객체 하나만 사용한다. 
	}

}
