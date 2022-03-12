

class Share{
	int i;
	public void pop() {
		for(int i=0; i<100; i++) {
			synchronized(this) {
				if(this.i==0) {
					//스레드 일시 중지 
					try {
						this.wait(); //i가 0이면 스레드 일시중지한다. 여기서 this생략 가능  
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//스레드 제어로 인스턴스가 절대 음수가 되지 못하게 
					
				}
				System.out.print("before pop:" + this.i);
				this.i--; //this.i값 -1, this.i에 대입 
				System.out.println(", after pop:" + this.i);
			}
			
		}
	
	}
	public void push() {
		
		for(int i=0; i<100; i++) {
			synchronized(this){//괄호에 공유객체를 넣어주는데 현재 객체니까 this를 넣어준다. 
				this.notify();//this가 생략되어 있는 것이다 
				System.out.print("before push:" + this.i);
				this.i++;
				System.out.println(", after push: " + this.i);
				
			}
		}
			
			
		}
	}
	
	
	
	

class Pop extends Thread{
	Share s;
	Pop(Share s){
		this.s = s;
	}
	public void run() {
		s.pop();
	}
}

class Push extends Thread{
	Share s; 
	Push(Share s){
		this.s = s;
	}
	public void run() {
		s.push();
	}
}
	


public class ShareTest {

	public static void main(String[] args) {
		Share s;
		s= new Share();
		Pop pop;
		pop = new Pop(s);
		//pop.s = s; 
		
		Push push;
		push = new Push(s);

		pop.start();
		push.start();
		
		
		
		

	}

}
