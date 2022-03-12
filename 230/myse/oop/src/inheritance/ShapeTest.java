package inheritance;
class Shape{
	protected double area;
//	void makeArea() {
//		
//	}
//	
	void printInfo() {
		System.out.println("면적은" + area + "입니다.");
		
	}
}
class Circle extends Shape{
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
		System.out.println("반지름이" + radius + "인 원의" );
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
		System.out.println("가로" + width + "세로" + height+ "인 사각형의" );
		super.printInfo();
	}	
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

	public static void main(String[] args) {
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(3,4);  //가로3, 세로4인 사각형 객체 
		Triangle t = new Triangle(2,3); //밑변2, 높이3인 이등변삼각형 객체  
		c.makeArea();   //원의 면적을 구한다. 
		r.makeArea();   // 사각형의 면적을 구한다. 
		t.makeArea();   // 삼각형의 면적을 구한다. 
		
		c.printInfo(); //반지름이 5인 원의 면적은 ~입니다. 
		r.printInfo(); // 가로3, 세로4인 사각형의 면넉은 ~입니다.
		t.printInfo(); //"밑변2, 높이3인 이등변삼각형의 면적은 ~입니다." 출력한다. 
		Shape s; //Sape타입의 s 변수 
		s = c; //s에 c변수 값을 대입한다. 
//		s.makeArea();
		s.printInfo();//shape에서 제고되는 area나 printInfo를 호출할 수 있지만 makeArea는 호출이 불가하다. 
		
		Shape []arr = new Shape[3];
		arr[0] = c;
		arr[1] = r;
		arr[2] = t;
		for(int i=0; i<arr.length; i++) {
			arr[i].printInfo();  //각 인덱스에 자식 타입 참조하도록 하였다. 
		}

	}

}
