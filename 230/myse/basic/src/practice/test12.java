package practice;

public class test12 {
	public static void main(String[] args){
    	int sum = 0; //합계를 저장할 변수 // int타입의 sum을 선언하고 초기값으로 0을 대입 
        
        int i = 1; //카운터 변수 
        
        
        while(i<=100) {
        	sum += i;
            i++; 
            
        }
        System.out.println("1~" + (i-1) + " 합: " + sum);
      }//sum은 합게를 저장할 변수 
  }
        
        


