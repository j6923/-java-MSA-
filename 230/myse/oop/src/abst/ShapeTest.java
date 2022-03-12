package abst;
 
 abstract class Shape{
	 // abstract을 붙여서 추상클래스로 만든다. 
	protected double area;
	abstract void makeArea();
	
	void printInfo() {
		System.out.println("면적은 " + area + "입니다.");
		
	}
}
class Circle extends Shape{
	//Shape클래스를 상속받는 Circle클래스를 만든다. 
	private int radius;
	//확장되면 double로 하는것이 좋을 것 같다. 
//	private double area;  //면적 
	Circle(int radius){
		this.radius = radius;
	}
	void makeArea(){
		
		area =  Math.pow(radius, 2)* Math.PI; 
	}
	void printInfo() {
		System.out.print("반지름이" + radius + "인 원의 " );
		super.printInfo();  //super란 현재 객체의 부모를 말한다. 
		// 자식 개게 내부에 부모객체가 있어서 부모 영역이 먼저 할당 된다고 그랬는데 
		//현재 사용 객체의 shape의 printInfo 메서드를 말한다 
	}	
}
class Rectangle extends Shape{
	private int width;
	private int height;
//	private double area;
	
	Rectangle(int width, int height){   
		this.width = width;
		this.height = height;
	}
	
	void makeArea(){
		area = height * width;	
	}
	
	void printInfo() {
		System.out.print("가로" + width + ", 세로" + height+ "인 사각형의" );
		super.printInfo();
	}	
}
class Hexa extends Shape{
	void makeArea() {
		//makeArea 재정의 
		System.out.println("육각형의 면적을 계산한다.");
	}
	//
}

class Triangle extends Shape{
	private int base; //밑변 
	private int height;
//	private double area;
	Triangle(int base, int height){
		this.base = base;
		this.height = height;
	}
	void makeArea() {
		area = base * height/2;   //maekArea메서드 호출할때 계산하도록 하려는 의도 	
	}
	
	void printInfo() {
		System.out.print("밑변" + base + "높이" + height+ "인 이등변삼각형의");
		super.printInfo();
	}
	
}

public class ShapeTest {
	public static void m(Shape s) {
		s.makeArea();
		s.printInfo();
	}
//	public static void m(Shape s) {
//		Shape s = new Shape(); 
//		//부모타입으로 매개변수 함. 
//		s.makeArea();
//		s.printInfo(); 
//		//circle의 오버라이딩 된 메서드가 출력됨. 
//		//m메서드 
		
//	}

	public static void main(String[] args) {
		
		//Shape s = new Shape();  //s변수를 Shape으로 선언하고 new 키워드로 객체한다. 
		
		Circle c = new Circle(5);
		m(c);  // m의 c로 인자 전달 
		
		Rectangle r = new Rectangle(3,4);  //가로3, 세로4인 사각형 객체 
		m(r);
		Triangle t = new Triangle(2,3); //밑변2, 높이3인 이등변삼각형 객체  
		m(t);
		Hexa h = new Hexa();
		m(h); //부모 다 상속받아서 h를 전달하면 하위클래스여서 upcasting이 되어서 
	}

}
