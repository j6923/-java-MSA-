package inheritance;
class Parent{  //extends Object
	private int i;
	Parent(int i){
		this.i = i; 
	}
	//hashcode가 자식출력되기 원해서 자식으로 해야 한다. 
	public int hashCode() {
		return i;
	}
	/**
	 * 현재 객체의 i값과 매개변수 객체의 i값이 서로 같으면 true를 반환
	 * 그 외의 경우 false를 반환한다. 
	 */
//	public boolean equals(Object obj) {
//		if((obj instanceof Parent)==false) {
//			return false; 	
//		}이렇게도 할 수 이고 
	
	
//	public boolean equals(Object obj) {
//	if(!(obj instanceof Parent)) {
//		return false; 	
//	}이렇게도 할 수 이고 
		public boolean equals(Object obj) {
			if(obj instanceof Parent) {
				Parent p = (Parent)obj;
				if(this.i == p.i) {
					return true;
				}
			}
			return false;
		}
	
//		Parent p = (Parent)obj;
//		if(this.i == p.i) { 이렇게 
//			return true;
//		}
//		return false; //if문을 빠져나와서 이 구문을 실행하게 됨. 
		
//		if(this.i == obj.i) {  //object 클래스에는 i변수가 존재하지 않음. parent에는 i라는 멤버변수가 없음. 
		//전달된 obj 갹체를 casting parent타입으로 강제형변환함. 그러면 p.i 변수가 존재하게 된다. 
//			return true;
//			
//		} else {
//			return false; 
//		}
		public String toString() {
			return "Parent의 Overriding된 toString()메서드입니다.";	
	}
}

public class ObjectTest {
	public static void test(Object obj1, Object obj2) {
		System.out.println("-------test start----------");
//		if(obj1 == null || obj2 == null) {
//			System.out.println("매개변수 객체는 null이 될 수 없습니다. ");
//			return;  //메서드 끝내겠다. 리턴값이 없을 때는 
//		} 안 한다고 하면 
		if(obj1 != null) {
			//null이 아닐 때에만 아래 작업을 하고 
			System.out.println("obj1.hashbode()=" + obj1.hashCode());
		}
		if(obj2 != null) {
			System.out.println("obj2.hashbode()=" + obj2.hashCode());
		}
		if(obj2 != null) {
			System.out.println("obj1.toString()=" + obj2.toString());
		}
		if(obj1 != null) {
			System.out.println("obj1.equals(obj2)=" + obj1.equals(obj2));  //obj2가 null이어서 parent equals 
			//그래서 return false가 된다. 
		}
//		System.out.println(obj1.hashCode());
//		System.out.println(obj2.hashCode());  //객체의 주소값이다. 
//		System.out.println(obj1 == obj2);  //참조하는 객체가 서로 달라 false가 나옴. 
//		//다른 객체이다. 
//		
//		System.out.println(obj1.toString());
//		System.out.println(obj2.toString());// 갹체 정봇값이어서 windows os면 똑같은 jvm을 쓰고 있어 객체 정보값은 동일할 수 밖에 없다. 
//		// C에서는 jvm을 쓰는 것이 아니고 직접 메모리를 사용해서 hash코드값을 보면 서로 다를 수가 있지만 java는 동일한 jvm을 사용하여 메모리는 비슷할 것이다. 
//		// 너무 메모리 번지수라고 생각하지 말고 객체 정보값이라고 봐야 한다. 
//		
//		System.out.println(obj1.equals(obj2)); //참조하는 객체가 같은 객체인가요? 아니요 니까 false ==과 같은 효과를 낸다. 
//		// 비교연산자 ==을 쓰지 왜 똑같은 일을 하는가? 다형성 때문에 
		System.out.println("---------test end------------");
	}
	public static void main(String[] args) {
		Object o1, o2; //java.  object를 o1, o2로 생성. 
		o1 = new Object();  
		o2 = new Object();
		test(o1,o2); // 6줄 짜리 코드를 
		
		
		Parent p1, p2;
		p1 = new Parent(10);          p2 = new Parent(10);  //parent의 매게변수 생성자와 default생성자도 없음
		//생성자 인자로 전달 
		
		
		test(p1,p2);
		
		test(p1, o1); //test에 parent타입에 p1과 object 타입의 o1을 한다. 
		test(p1, null);
		System.out.println("-----System.out.println()-------------");
		System.out.println(1);
		System.out.println(false);
		System.out.println(o1);
		System.out.println("hello");  //string 타입이 되는 
		
		System.out.println(p1);  //p1.toString() 자동호출됨. 
		System.out.println(p1.toString());// 위의 결과와 동일하다. 
		
		p1 = null;
		System.out.println(p1);    //null
		System.out.println(p1.toString());//  호출해서 인자로 사용하면 NullPointerException발생 
		
		
		
		

	}

}
