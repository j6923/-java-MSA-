class B{
	int iv;  //member field 라고 부름 
	// static 안 부은 애를 인스턴스 변수-non static변수라고 부름
	static int sv;   //static은 멤버 필드에서만 가능 
	
	
	void im() {
		sm();  //this.sm()
		System.out.println(iv);   //this.iv
		System.out.println(sv);   // this.sv 
	}
	static void sm() {
//		im();//this.i,(); 이라고 보면 되는데 static 에서는 this사용이 불가함. 
		//sm 메서드 호출하는 방법이 
//		System.out.println(iv);  //이것도 안 됨. 인스턴스 불가, 인스턴스 변수도 불가 
		System.out.println(sv); //는 가능 
	}
}
/**
 * static변수 :  객체와 무관한 객체들간의 공유변수로 사용됨. 
 * 				클래스 로드 후 자동 초기화된다. 
 * 			   사용법 - 객체참조변수.static변수
 * 프로그램이 끝나야 static 변수 없어짐. 
 * static 메서드 : 객체와 무관한 기능 제공
 *               하기 위해 만듬 
 * 				사용법  - 객체참조변수.static메서드();
 * 				클래스명.static메서드();
 * 			static메서드 내부에서는 this 사용못함, 인스턴스메서드 사용못함, 인스턴스변수 사용못함. 
 * @author KOSTA
 *
 */
public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b1 = new B();
		B b2 = new B();
		b1.iv = 10;
		System.out.println(b1.iv);  //10
		System.out.println(b2.iv);  //0 
//		System.out.println(b1.sv);  //0
		System.out.println(B.sv);
		
		b1.sv++; 
		System.out.println(B.sv); //1로 증가된 것을 볼 수 있다, 
		System.out.println(b2.sv); //1 
		// 될수 있으면 static 처리 방법으로 해라 
		
		
		b1.im();
		b1.sm();
//		B.im();   // 객체 생성 하지 않고도 할 수 있ㅇ므.  
		B.sm(); 
		
	}

}
