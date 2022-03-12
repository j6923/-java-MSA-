package inheritance;

public class Truck extends Car{
	//자기만의 특성 없으면 아무것도 없어도 됨. 
	private int wheelCount;  //바퀴수
	public void setWheelCount(int wheelCount) {  //스피드도 가지고 있는 것. 
		this.wheelCount=wheelCount;
	}
	public int getWheelCount() {
		return wheelCount;
	}
	public void printInfo() {
		System.out.println("속도: " + speed+ ", 바퀴수:" + wheelCount);
	}

}
