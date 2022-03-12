package inheritance;

public class CarTest {

	public static void main(String[] args) {
		Car c = new Car(); //Car타입의 객체 생성 
		for(int i=0; i<10; i++) {
			c.speedUp(); //가능함 
		}
		//트럭타입의 객체 생성 
		c.printInfo();
		Truck t = new Truck();
		t.setWheelCount(12);
		t.speedUp(); 
		//부모의 private은 상속은 되지만 접근은 불가 
		t.printInfo(); //트럭의 현재 속도 얼마인지 확인 

	}

}
