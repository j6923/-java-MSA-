class Datatype{
	public static void main(String[]args){
        // 정수형
        byte b = 127; 
        b = 127;
        //b = 128; //error 발생 
   
        int i = 5; 
	System.out.println(i); //5
	System.out.println(5); // 컴파일러가 5를 int로 판단

	//long lo = 123456789012345; 
 	//long lo1 = 12345678901234;
	long lo2 = 12345678901234L;
	
	double d = 45.67;
	System.out.println(d); //45.67 
	
	//i = 45.67;  //  error 발생 : 실수 값을 대입해서 컴파일러가 에러를 발생시킴  
	System.out.println(45.67F); // float 타입은 뒤에 F를 붙임. 


	// 문자형 
	char c; 
	c = 'A'; 
	c = 49; //'1'과 같음
	System.out.println(c); 


	c= 44032; //'가'와 같음
	System.out.print(c); 


	//논리형
	boolean flag; 
	//flag = True; //TRUE; //error 발생
	flag = true;


	//자료형 변환 
	//자동 형변환 : byte-> short-> int-> long -> float -> double
	//              char-> 
	i = b;  // int타입 변수에 자동형변환되어서 int타입으로 전환이 됨. 
	d = i; 
	System.out.println(b); //127
	System.out.println(i);  // 127
	System.out.println(d); //127.0 

	i = c; //'가'의 utf-16값이 i에 대입 
	System.out.println(i); // 44032 

	//강제 형변환 : 더 큰 자료형의 값을 더 작은 값으로 꾸겨넣는... 그럴때는 값을 중간에 잃어버릴 수 있음 
	i = 128; 
	//b = i;  // error발생 
	b = (byte)i; //강제형변환연산자() cast연산자라고 함. 
	System.out.println(b); //-128~127까지 가능한데 그 값을 넘어선 128이 대입됨.   //-128로 값이 넘어간 것을 확인할 수 있다. 
	
	i = 129; 
	b= (byte)i; 
	System.out.println(b); //최소값으로 돌아가서 -127이 됨 

	d = 45.67;
	i = (int)d; 
	System.out.println(i); // 소수점이하가 잘려버림. //45 
	

	
	
	}
}