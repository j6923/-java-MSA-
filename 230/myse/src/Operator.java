class Operator{
	public static void main(String[]args){
	//산술연산자 +, -, *, /, % 
	int a, by, c; 
	a = 2; 
	by=3;
	c=a+b;  //5 
	c=a/b; // 0임 int를 int를 나누면 정수로 나옴.   
	double c1 = a/by; //0.0   단지 정수를 실수를 바꿨보았자 .0만 붙음. 
	double c2 = a/by; //실수를 실수로 나누면 실수 둘중하나가 실수면 강제 형변환이 되어서 실수가 됨. 0.5  
	
	short s1, s2,s3;
	s1=2; 
	s2=3;
	//s3=s1+s2; //error short타입은 int보다 작은 자료형인데 산술 연산에 참여할 수없어 적어도 4byte의 메모리가 있어야 산술연산에 참여할 수 있음. 
//자동 int타입으로 변환되어서 산술 연산에 참여하게 됨. 산술 연산할 떄 int타입으로 임시 자동형변환됨. 
// 강사님 정리: int보다 작은 자료형은 산술연산불가하다. 산술연산시 int로 자동형변환됨. 

	//s3=(short)s1+s2;   //s1변수만 short타입으로 바꿈.   //int가 되었고  
	s3=(short)(s1+s2); // s1+s2 형변환 먼저하고 short로 강제 형변홤함. 
	//증감연산자 ++, -- 
	byte b=127; 
	b++;  //b변수값을 1증가한다. 
	System.out.println(b); //-128    //1byte 메모리 안에서 +1시키면 값의 범위 넘어서면 최소값으로 돌아감 그러므로 주의해야 함. 

	a=2; 
	b=a++;    //되도록 다른 연산자와 쓰지 말자 .쓰자면 결과가 얼마인지 예상하자. 
	// 다른 연산부터 먼저하고 증가함. b변수에 대입이 되고 ++연산이 이루어짐. 
	System.out.println(b); //2
	b=++a; 
	//++연산부터 하고 b변수에 대입 
	System.out.println(b); //3

	
	//대입연산자  = , +=, -=, *=, /=, %= 
	a=2;
	b=a+5; 
	a+=5; 
	
	//비교연산자 >, < , >=, <= ==, !=
	// true or false로 결과가 나옴. 
	a=2; 
	b=3; 
	boolean result = a>b;
	System.out.println(result); //false 
	System.out.println(a!=b); //true
	System.out.println(a==b); //false 
	

	// 논리연산자 &, &&, |, ||, ! 
	2<3 && 2%3==1;  //논리연산자는 나중에 연산이 됨.  and
	//산술연산자 -> 비교연산자 -> 논리연산자 // 2<3은 true가 나오고 2%3==1은 false가 나옴. ---> ture and false는 false가 나옴. 
        // 좌우측 모두 true인 경우만 true 반환 , or는 둘중하나만 true면 true 
	// 대입연산을 and 
  //	(2<3) && (2%3==1) 의 효과와 같다 
	System.out.println(result); //false 

	result = ture || false; 
	result = 2<3 || 2%3 ==1; 
	System.out.println(result); //true 
// 차이점 1개는 연산속도가 더 떨어지고 ||는 빨라짐. 
// short 서킷 브레이커 