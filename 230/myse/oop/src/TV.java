
public class TV {
	int channel;
	int volume;
	boolean power;
	boolean isPower(){ //매게변수 없음 
		//is power 메서드의 결과는 블린 타입의 값이어야 함. 매서드의 반환값이라고 함. 
		return power;  //파워 값을 반환 
	}
	void powerOn() {
		//반환할 값이 필요없는 메서드는 앞에 void를 선언하고 return할 값이 있으면 그 앞에 boolean같은 값 넣음 
		power = true; //매서드의 괄호 안에 매개변수 쓸 수 있음. 
		//리턴 타입 갖고 있다는 것은 사용자가 그 값을 반환받아 갈 수 있음. 
		// 메서드 만드는 것이 기능을 만드는 것 
		// 한 객체가 다른 객체에게 티비 객체의 기능을 호출하는 것 
		// 겨과 값을 반드시 반환하는 것은 return 타입이 있어야하고 그렇지 않을 경우는 void로 함. 
		//리턴 하지 않는 것은 사용자가 호출하고 마는 것. 
		
	}
	void powerOff() {
		power = false; 
	}
	void setChannel(int ch) {// 채널을 바꿈. 
		//현재 객체의 ㅊ
		channel = ch;// 매개변수가 ch가 되어야 하는 것 
		// 매개변수 ch에 대입된 값을 setchaanel에서는 리턴값이 없도록 막아주는 것 매개변수의 값을 현재 사용중인 객체에 대입하게 됨 
	}
	void volumUp() {
		volume++;
	}
	void printInfo() {
		System.out.println("전원은 " + power);
		System.out.println("채널은 " + channel);
		System.out.println("볼륨은 " + volume);
	}

}
