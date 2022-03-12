
public class Loop {

	public static void main(String[] args) {
		//while
		int num=0;
//		num++;   //1
//		num++;   //2
//		num++;   //3
		
		//5번 num변수값을 1증가하기 
		int i=0;
		while(i<5) {
			num++; 
			i++;  //반복횟수 
			System.out.println("반복 횟수:" + i +", num변수값:" + num);
		}
		
		num=1;
		
		// 5번 반복하면서 num변수값을 3배 증가하가ㅣ 
		i=0;
		
		 //num값을 0으로 초기화 
		   //3씩 곱하기를 해봄 
		while(i<5) {
			num*=3;
			i++;
			System.out.println("반복횟수:"+ i +", num변수값:" + num);
		}
		
		
		num=1;
		i=0;
		int sum=0;
		
//		sum += num;  //sum=sum+num;  sum=0+1;
//		num=2;
//		sum += num; //sum=sum+sum; sum=1+2;
//		
//		num=3;
//		sum+= num; //sum=sum+num; sum-3+3; 
//		
		//num을 sumㅇ로 누적, 즉 합을 구한다. //하나의 스탭으로 구하면 0+1+2+3 
		//5까지의 합을 구하면 
		
		while(i<10) { //1에서 5까지의 합을 구하는 작업 //i가 0이므로 10미만까지 하면 10개가 됨. 
			//변하지 않는 구분 반복문 안쪽에 넣기 
			sum+= num; 
			//그 다음 변하는 구문을 넣으면 됨. 
			num++; 
			i++;
			
			//변수를 최소화하자. 
		}
		System.out.println("1~10까지의 합:" + sum);
		
		
		num=1;
		sum=0;
		while(num<=10) { //1에서 5까지의 합을 구하는 작업 //i가 0이므로 10미만까지 하면 10개가 됨. 
			//변하지 않는 구분 반복문 안쪽에 넣기 
			sum+= num; 
			//그 다음 변하는 구문을 넣으면 됨. 
			num++; 
			i++;
			
			//변수를 최소화하자. 
		}
		System.out.println("1~10까지의 합:" + sum);
		// 1~10까지의 숫자를 출력하시오. 
		num=1;
		while(num<=10) {
			System.out.println(num++);
			
		}
		
		System.out.println("1~10까지 중 홀수를 출격하시오. 1,3,5,7,9 ");
		i=1;
		while(i<=10) {
			if(i%2!=0) {
			System.out.println(i);
			}
			i++; 
			
		}//나 
		
		
		num=1;
		while(num<=10) {
			System.out.println(num);//2씩 증가하면 1을 포함한 홀수를 뽑을 수 있다. 
			num+=2;
		}
		
		
		
		
		
		System.out.println("1~10까지의 숫자중 홀수의 합을 구하여 출력하시오."); 
		int oddSum=0; 
		num=1;
		while(num<=10) {
			oddSum+= num; 
			num+=2;
			System.out.println(oddSum);
		}
		
		
		//홀수를 출력하시오. 1,3,5,7,9,11,13,15,17,19 
		//1부터 총 10개의 홀 수를 출력 
		num=1;
		i=0;
		while(i<10) {
			System.out.println(num);//2씩 증가하면 1을 포함한 홀수를 뽑을 수 있다. 
			num+=2;
			i++;
		}
		// A, B,C,D,E,F,G를 출력하시오. 
		// 반복문 사용안하면 System.out.println();로 할 텐데 
		char c='A';
		while(c<='G') {
			System.out.println(c);
			c++;  //char타입은 int타입으로 자동 형변환 가능 //'A'+1 int타입이 되어 버림. => B   65가 A 
			//7번 반복 수행해도 되고 g일 때까지 비교해도 됨 
		}
		
		//키보드로 값 입력하기 
//		System.out.println("입력하세요");
		//사용자에게 값을 입력받아야 함. 
		java.util.Scanner sc; //java타입의 util의 
		sc= new java.util.Scanner(System.in);  //한번만 sc변수 선언하면 계속 키보드로 값을 받을 수 있음. 
		
		
		String readValue="";
//		while(!readValue.equals("quit")) {//while을 만족해야 다음 조건 수행 // 즉 quit과 quit을 만족할 때 반복해라 
//			//equal앞에 !붙이면 not연산이 됨. 
//			System.out.println("입력하세요(종료하려면 quit을 입력하세요):");
//			readValue = sc.nextLine();// 리턴타입이 string타입임. //sc로 nextLine을 함. 
//			System.out.println("입력하신 값은 " + readValue + "입니다.");
//			i++; //10번 반복 수행을 하겠다. 
//		}
		
		//입력된 값이 따라서 반복을 유지할 지 아닐지 유지하고 싶어요 .
//		readValue="";
//		while(true) { //무조건이라는 의미의 true로 하고 
//			System.out.println("입력하세요(종료하려면 quit을 입력하세요):");
//			readValue = sc.nextLine();
//			if(readValue.equals("quit")) {//quit 문자어 같은 때 
//				break; 	
//			}
//			System.out.println("입력하신 값은 " + readValue + "입니다.");	
//		}; 
		
		//2중 반복문 : 반복문 안에 반복문이 있는 구조 
		// 구구단 4단  *1 !*9
		int dan = 4;  //4단만이 아니고 4,5,6 반복 수행이 되어야 함. 
		num = 1; 
		while(num<=9) {
			System.out.print(dan*num + "\t"); // 탭 만큼 띄어쓰기한다는 의도 
			num++;
			
		}
		
		dan=2; 
		while(dan<=8) {
			num=1;
			{while(num<=9) {
				System.out.println((dan*num)+"\t");//while 안쪽에서 9까지 하면 밖의 것이 실행이 됨. 
				num++;
			}
			
			System.out.println();
			dan++;
			}
		// 10의 배수는 출력에서 제외하고 싶어요. 
			dan=2; 
			while(dan<=8) {
				num=1;
				{while(num<=9) {
//					if(dan*num%10!=0) {
//						System.out.println((dan*num)"\t");
//					}
					if(dan*num %10 ==0) {
						num++;
						continue;
					}
						System.out.print((dan*num)+"\t");
						num++;
					}
					System.out.println();
					dan++;
				}
					
				
				
				
				}
			//피보나치수열값을 10개를 출력하시오. 
			//1,1,2,3,5,8,13,21, 34, 55 ... 
			int bb=1; //이전이전숫자 
			int b=0; //이전숫자 
//			int current= bb+b; //1
			
//			bb = b; //0
//			b = current; //1 
//			current = bb + b; //1 
//			
//			bb= b;  //1 
//			b = current; //1 
//			current = bb+b; //3  //10번 수행 
			int current;
			i=0;
			while(i<10) {
				current=bb + b; //1
				System.out.println(current + "\t");
				bb=b; //0
				b=current; //1
				i++; 
				
			}
			//소수 판별 
			// 
			
			
		//for(초기; 조건식; 증감식){}
		System.out.println("-------- for.1-------");//위의 while문 for문으로 변경함. 
		int numa=0;
		for(int a=0; a<5; ) {//증감식 필요없으면 안 써도 됨. 
			numa++;
			a++;			
			System.out.println("반복횟수" + a +", num변수값"+ numa);
		}
		System.out.println("---------------------------------");
		//5번 반복하면서 num변수값을 3배 증가하기 
		
		
		
		//do while
		}
//		numa=1;
//		for(int a=0; a<5;) {
//			numa*3=3;
//			a++;
//			System.out.println("반복횟수:"+ a + ", num변수값:" +numa
//		;
		
		int numa=1;
		for(int a=0; a<5;) {
			numa*=3;
			a++;
			System.out.println("반복횟수:" + a + ", num변수값:" + numa);
		}
		System.out.println("----------");
		//반복횟수 
		int suma = 0;
		numa = 1;
		for(int a=0; a<10; a++) {
			suma += numa;
			numa++;
			//a++;
		}
		System.out.println("1~10까지의 합:" + suma);
		System.out.println("----------");
		
		for(numa =1, suma=0; numa<10; numa++) {  //초기치 증감치 여러값 초기와 여러값 증감 가능 , 로 
			suma += numa;
			
		}
		System.out.println("1~10까지의 합:" + suma);
		System.out.println("----------");
		for(numa= 1; numa<=10; numa+=2) {
			System.out.println(numa);
		}
		System.out.println("--------------------------");
//       for(char ca='A'; ca<='G'; ca++) {
//    	   System.out.println(ca);
//       }
//		
//		System.out.println("-------for, 6-----------");
//	 	for(; !readValue.equals("quit");) {
//	 		System.out.println("입력하세요");
//	 	}
	 	
	 	//quick 부분을 do- while로 변경
	 	
	 	System.out.println("--do while----");
	 	
//	 	do {
//	 		System.out.print("입력하세요(종료하려면 quit을 입력하세요):");
//	 		readValue=sc.nextLine();
//	 		System.out.println("입력하신 값은"+ readValue + "입니다,");
//	 	}while(!readValue.equals("quit"));  //입력을 받고 그 다음 조건 비교를 하는 것. while이랑 비교했을 떄 무조건 먼저 수행되어야 
	 	//하는 경우 
	 	// 수행을 먼저 하고 계산된 값을 가지고 비교해야 하는 경우 do-while구문을 사용하는 것이 적절하다. 
	 	
	 	//문제 숫자1부터의 합이 100미만인 최대숫자(저수)를 출력하시오.
	 	//합이 100미만이 되는 경우 
	 	//1+2+3+... 합이 13미만이 될 수 있는 숫자의 값
//	 	int sum1=0;
//	
//	 	num = 1; 
//	 	do {
//	 		sum1+=num;
//	 		num++;
//	 		sum1++;
//	 		System.out.println(num);
//	 	}while(sum1<100);
//	 	// 1~10까지의 숫자를 출력하시오. 
//		int sum1=0;
	 	sum=0;
	 	num = 1; 
	 	while(sum+num < 100) {
	 		sum += num;
	 		num++;
	 	}
		num--;//5가 되어서 뺴야 함. 
		System.out.println();
		System.out.println("최대숫자는 "+ num); 
		
	
		sum = 0; 
		num = 0; 
	 	do {
	 		num++;
	 		sum += num;
	 		System.out.println(num +":"+sum);
	 	}while(sum+(num+1)<13);
	 	
		System.out.println("최대숫자는 "+ num);
	 	
	}
		
	}
	

