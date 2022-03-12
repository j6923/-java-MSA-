import java.text.SimpleDateFormat;
import java.util.Date;

class Video extends Thread{

	@Override
	public void run() {
		for(int i=1; i<= 50; i++) {
			System.out.println("비디오" + i);
		}  //run 메서드에 오버라이딩 한다. 
		// cpu가 점했을 때의 할일을 말한다. 
		
	}
	//메서드 
}

class Sound extends Thread{
	@Override
	public void run() {
		for(int i=1; i<= 50; i++) {
			System.out.println("사운드" + i);
		}  //run 메서드에 오버라이딩 한다. 
		// cpu가 점했을 때의 할일을 말한다. 
	}
}

class Timer extends Thread{
	//이 스레드가 할 일은 현재시간을 100번 출력한다. 
	//Date, Calendar, SimpleDateFormat, printf...
	private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //잠을 자는 일시중지 상태로 만든다. static메서드여서 클래스. 
		}
	}
	
	
}

public class ThreadTest {
	
	public static void m() {
		Thread t = Thread.currentThread(); //현재 사용중인 thread를 얻어낼 수 있다. 
		System.out.println("m()를 호출한 thread:" + t.getName());  //thread 이름 자체가 main이다. 
		
	}

	public static void main(String[] args) {
		Thread t = Thread.currentThread(); //현재 사용중인 thread를 얻어낼 수 있다. 
//		t.getName(); //스레드 이름을 확인한다. 
		System.out.println("main()를 호출한 thread:" + t.getName());  //thread 이름 자체가 main이다. 
		//어느 cpu가 점거할 지 모른다. 
		//thread가 쉬운게 아니고 
		
		//새로운 스레드 객체 생성    //t
		//video 스레드 객체 생성 
		
		Video v = new Video();
		Sound s = new Sound();
		// 스레드 시작 
		//v.run(); run메서드 직접 호출해서는 안되고 반드시 start로 시작해야 한다. 
		Timer timer = new Timer();
		
		v.start();   //v.run는 객체 시작하는 것으로 마무리해야 한다, 
		s.start();
		timer.start();
		
		m();
		

	}

	

}
