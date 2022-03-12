//스레드 빠져나오는 방법에 대해 알아보자. 
//stop은 권장하지 않는다. 
class Stop extends Thread{
	boolean flag = true;  //변수 만들고 기본 값으로 true를 준다. 
	public void run() {
		while(flag) {
			System.out.println("run..."); //계속일을 하는 애 출력 
			//dead 상태에 빠지지는 못한다. 왜냐하면 계속 cpu를 점하고 있기 때문이다. 
		}
	}
}
class Stop1 extends Thread{
	int max = 10000; //만번 반복 수행하도록 
	public void run() {
		for(int i=0; i<max; i++) {
			System.out.println("run:" + i);
		}
	}
}
public class StopTest {

	public static void main(String[] args) {
//		Stop s = new Stop();
//		s.start();//객체생성해서 시작 시킴 
//		try {
//			Thread.sleep(1000);//효과 극대화 시키기 위해 1초 일시 중지시킴. 
//			s.flag = false;   //flag가 false가 되어서 while 반복문   //제어하기 위해 flase주면 start되었다가 그 죽시 죽어버림. 
//			// 이것과 같이 run메서드 자연스럽게 빠져나오는 것이 좋다. 
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		Stop1 s1 = new Stop1();
		s1.start(); // 만번 반속 수행하면서 
		s1.max = 0;  //스레드의 맥스 값이 0이 되어서 더이상 반복 수행하지 않음. 
		//while인 조건문 제어하면 되고
		// for 반복문의 조건치 제어하면 중지 할 수 있다. 

	}

}
