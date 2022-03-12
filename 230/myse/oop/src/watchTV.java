
public class watchTV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv;
		tv = new TV();
//		tv.power = true; //전원을 켠다. 
//		tv.channel =7; //채널을 7번으로 바꾼다. 
//		tv.volume = 10; //소리는 10으로 설정한다. 
//		System.out.println("TV전원은" + tv.power);
//		System.out.println("채널은"+tv.channel); //7
//		System.out.println("볼륨은" + tv.volume);  //10
		boolean powerFlag = tv.isPower();  //사용자가 사용할 때 이름하고 괄호 이런 메서드가 선언이 되어있어야 함. 
		// is power 
		if(powerFlag == false) {
			tv.powerOn();  //전원을 켠다.
			tv.setChannel(7); //채널은 7로 설정한다. 
			for(int i=0; i<10; i++) {
				tv.volumUp();
			}
			System.out.println("채널은 "+tv.channel);
			System.out.println("볼륨은 " + tv.volume);  //10 
			
		} else {
			tv.powerOff(); //전원을 끈다. 
			  //채널을 7로 설정한다. 
		}
//		if(!powerFlag) {
//			tv.powerOn(); //powerflag가 아닐 경우 해도 if(powerFlag == false와 같다. 
//		}
		
		
	}

}
