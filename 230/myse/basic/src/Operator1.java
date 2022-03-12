class Operator1{
    public static void main(String[]args){
        //산술연산자 +, -, *, /, %
        int a, b, c;
        a=2;
        b=3;
        c=a+b; //5
        c=a/b; //0
        double c1 = a/b; //0.0
        double c2 = (double)a/b; //0.5
 
        short s1, s2, s3; //int보다 작은자료형은 산술연산불가하다. 산술연산시 int로 자동형변환됨
        s1=2;
        s2=3;
        //s3=s1+s2; 
        s3= (short)(s1+s2);

       //증감연산자 ++, --
       byte by=127;
       by++; //by변수값을 1증가한다
       System.out.println(by); //-128

       a=2;
       b=a++;
       System.out.println(b); //2
       
       a=2;
       b=++a;
       System.out.println(b); //3

       //대입연산자 =, +=, -=, *=, /=, %=
       a=2; 
       a=a+5;
       
       a=2;
       a+=5;
       
       
       //비교연산자 >, <, >=, <=, ==, !=
       a=2; 
       b=3;
       boolean result = a>b;
       System.out.println(result ); //false
       System.out.println(a!=b); //true
       System.out.println(a==b);//false

       //논리연산자 &, &&, |, ||, !
       result = 2<3 && 2%3==1;
       System.out.println(result ); //false

       result = true || false;
       result = 2<3 || 2%3==1;
       System.out.println(result ); //true
       
       
       //삼항연산자 
       a = 2;
       b = 3;
       c = a<b? 10: 20;
       System.out.println(c); //10
       c = a==b? 10: 20;
       System.out.println(c); //20
       
       //성별값이 1이거나 3인 경우엔 남자를 출력, 그외의 경우 여자를 출력
       int gend = 3;//2;//1; 
       System.out.println(gend==1 || gend==3? "남자":"여자");
       
       //성별값이 홀수인 경우엔 남자를 출력, 그외의 경우 여자를 출력
//       int gen=2;
//       System.out.println(gen%2==1? "남자":"여자");
       System.out.println(gend%2==1? "남자":"여자");
       // 앞에 조건부분이 boolean타입이어야 함. 
       
       
    }
}