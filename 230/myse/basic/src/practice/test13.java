package practice;

public class test13 {
	public static void main(String[] args) throws Exception { //예외 넘기기 
	boolean run = true;
    int speed = 0;
    int KeyCode = 0;
    
    while(run) {
    	if(KeyCode!=13 && KeyCode!=10) {
        	System.out.println("____________________________");
            System.out.println("1.증속| 2.감속 | 3. 중지");
            System.out.println("____________________________");
            System.out.println("선택: ");
        }
        
        
        KeyCode =System.in.read(); //키보드의 키 코드를 읽음. 
        
        if(KeyCode == 49) {//1을 읽었을 경우
        	speed++;
            System.out.println("현재 속도=" + speed); 
        }else if(KeyCode == 50){ //2를 읽었을 경우
        	speed--;
            System.out.println("현재 속도=" + speed); 
        }else if(KeyCode == 51) {//3을 읽었을 경우 
        	run = false;  //while문을 종료하기 위해 run 변수에 false를 저장
        }
    }
    System.out.println("프로그램 종료");
    }

}
