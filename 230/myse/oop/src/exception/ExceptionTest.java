package exception;

import java.util.Scanner;

public class ExceptionTest {
	
	public static void test(int num) {
		try {
			int mod = 99%num; //예외발생가능코드 
			System.out.println("99를 " + num + "으로 나눈 나머지값:" + mod); 
		}catch(ArithmeticException e) {//아무 처리 안 해도 된다.
			System.out.println("0으로는 나눌 수 없습니다.");
			
		}
}	
	
	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.println("0이 아닌 숫자값을 입력하세요: ");
		String line = sc.nextLine();
		try {
			//string 값을 int로 변환 
			int num = Integer.parseInt(line);  //예외발생가능코드 
			test(num);   //전달 string이고 기본자료형과 참조자료형은 서로 형변환이 불가하다. String과 int 와 같은 경우 	
			//에러가 발생하면 catch블럭으로 이동한다. 
		}catch(NumberFormatException e) {
			System.out.println("숫자값만 입력가능!");  //NumberFormatException예외 발생가능코드 
		}	
//		}catch(ArithmeticException r) {
//			System.out.println("0은 입력불가!");
//		}
		System.out.println("프로그램의 끝입니다. ");  //특정 exception명 클래스명을 적어주면 된다. 
		
	}

	}
