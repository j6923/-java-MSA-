package inheritance;

public class Car {
	//private int speed;
	//public Car(){} //default constructor
	protected int speed;  //private으로 int타입으로 speed인 속도계로 필드를 만든다. 
	public void setSpeed(int speed) {
		this.speed = speed;  //필드 speed를 매개변수 speed로 설정한다. 
	}
	public int getSpeed() {
		return speed;
	}
	public void speedUp() {
		speed++;
	}
	public void speedDown() {
		if(speed >0) {
			speed--;
		}
	
		
	}
	public void printInfo() {
		System.out.println("속도" + speed);
//		System.out.println("바퀴수" + getWheelCount());  //자식의 메소드는 부모쪽에서 사용불가
		//Child Methed 호출 불가 
	}
	 
}
