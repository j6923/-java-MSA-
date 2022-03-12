class Gray extends Thread{
	int start, end; //멤버변수 두 개를 선언한다. 
	int sum; //sum이라는 변수 선언 
	Gray(int start, int end){
		this.start = start; //값 대입 
		this.end = end; //값 대입 
	}
	public void run() {
		for(int i=start; i<=end; i++) {
			sum  += i; //합을 구함. 
		}
	}
}
public class JionTest {

	public static void main(String[] args) {
		Gray gray = new Gray(1,10); //그레이에 그레이 객체를 만든다.   인자값 전달 된 경우 start 에서 end까지 합을 구한다. 
		Gray gray2 = new Gray(11,20);
		
		gray.start(); //gray가 가지고 있는 스레드 시작 
		gray2.start(); 
		try {
			gray.join();  //main스레드가 gray스레드 끝날 때까지 
			gray2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("1~10까지의 합:" + gray.sum); //그레이 스레드의 합을 출력한다.
		System.out.println("11~20까지의 합:" + gray2.sum);
		//main 스레드가 하나 있고 객체 생성한 하나 있다. 
		//두 스레드 중 어느것이 cpu점유할 지 아무것도 모름. 
		// 그리고 얼마나 점유할 지도 모른다. 
		// main cpu가 먼저 점유 했다고 하면 syso가 할 일 
		// 메인 스레드가 초기값 0값이 출력 /// cpu점유 안 한 상태 
		// gray가 먼저 cpu를 점유했다고 할 때 run 메서드 호출할 것이다. 반복 수행하면서 sum을 구하겠지만 상황이 좋지 않은 커뮤터면 cpu점유했을 때 1부터까지만 7 반복했다고 하면 나가라고 하면 
		// 어떨 수 없이 나와야 해서 run상태로 와야 한다. 그레이는 1부터 7까지의 합까지밖에 없을 것이다. 
		//main스레드가 먼저 실행되면 1~7 까지의 합이 보인다. 
		
		//시나리오 2 
		// 그레이스레드가 cpu를 점유하고 내쳐지지 않았다. 1~10까지의 합을 다 구하고 다 도달했다고 sum이 계속 dead상태로 빠지면 나머지 메인 스레드가 1~20 정확히 출력이 될 수 있을 것이다. 
		// join메서드라겸ㄴ 그레이.join이라고 하면 메인 스레드가 1씩 중지 gray스레드가 죽을 때까지 main쓰레드가 그 결과는 1~10까지의 합. 

	}

}
