package api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		String s = "가ABC";
		char c=s.charAt(0);//s를 대상으로 charAt을 해는데 
		System.out.println(c);
		
		byte[] bArr = s.getBytes();  //6bytes
		for(byte b: bArr) {   //가의 바이트개수 : 3bytes
			System.out.println(b);
		}  
		int index = s.indexOf("AB"); //특정문자의 위치값을 알아낼 수 있다. 
		System.out.println(index);//1
		index = s.indexOf("X");
		System.out.println(index);  //해당 문자 존재하지 않으면 -1을 반환
		
		int size = s.length();
		System.out.println(size);  //문자열의 길이 : 4 
		int beginIndex = 1; 
		int endIndex = 3; 
		String substr = s.substring(beginIndex, endIndex); //부분 문자열 반환 //index 1부터 3-1까지의 부분문자열  
		System.out.println(substr);
		
		//String palindrom = "토마토"; //"ABBA" 앞과 뒤가 꼭같은 문자열 
		System.out.print("Palindrom문자열 판별하기");
		Scanner sc = new Scanner(System.in);
		String palStr = sc.nextLine();  //입력값이 "경기도 성남시"엔터인 경우 -> "경기도 성남시"
		//sc.next(); -> "경기도"
		//TODO 결과가 Palindrom입니다,또는  Palindrom문자열이 아닙니다를 출력한다. 
		
		
//		int i = 0;
//		palStr=palStr.trim();
//		int palStrlen=palStr.length();
//		for(int j=0; j<palStrlen;j++) {
//			if(palStr.charAt(i)!=palStr.charAt(palStrlen-1)) {
//				System.out.println("Palindrom문자열이 아닙니다.");
//			}else {
//				System.out.println("Palindrom문자열입니다.");
//			}
//			j++;
//			palStrlen--;
//			
//		}
		//1 
		
		
		
//		int j =0;
//		for(j=0; j<palStrlen;j++) {
//			
//			}
//		if(palStr.charAt(i)!=palStr.charAt(palStrlen-1)) {
//			System.out.println("Palindrom문자열이 아닙니다.");
//		}else {
//			System.out.println("Palindrom문자열입니다.");
//			j++;
//			palStrlen--;
//			
//		}
//		
//		
//		
//		//2 
//		for(j=0; j<palStrlen;j++) {
//			
//			}
//		if(palStr.substring(i)!=palStr.substring(palStrlen)) {
//			System.out.println("Palindrom문자열이 아닙니다.");
//		}else {
//			System.out.println("Palindrom문자열입니다.");
//			j++;
//			palStrlen--;  
//			
//		}
//		
//		
		
		
//		do {
//			if(palStr.charAt(i)!=palStr.charAt(palStrlen-1)) {
//				System.out.println("Palindrom문자열이 아닙니다.");
//			}else {
//				System.out.println("Palindrom문자열입니다.");
//			}
//			i++;
//			palStrlen--;
//		}while(i<palStrlen/2);
		
		
//		do {
//			if(palStr.substring(i)!=palStr.substring(palStrlen)) {
//				System.out.println("Palindrom문자열이 아닙니다.");
//			}else {
//				System.out.println("Palindrom문자열입니다.");
//			}
//			i++;
//			palStrlen--;
//		}while(i<palStrlen/2);
		
		//위에 까지 나 
		
		int palStrSize = palStr.length(); //문자열길이
		int halfSize = palStrSize/2; //문자열길이의 1/2
		
		int i=0;
		for(; i<halfSize; i++) {
			int palStrEndIndex = palStrSize-1 - i;
			char c1 = palStr.charAt(i);
			char c2 = palStr.charAt(palStrEndIndex);
			if(c1 != c2){ //Palindrom문자열이 아닌 경우
				break; //
			}
		}
		if(i == halfSize) {
			System.out.println("Palindrom문자열입니다");
		}else {
			System.out.println("Palindrom문자열이 아닙니다");
		}
		
		System.out.println("--String의 split()메서드 -- ");
		String splitStr = "90:100:80";  //"국어점수:수학점수:영어점수"
		String delim = ":"; //구분자 //"?"면 문제가 발생한다. 파이프기호도 문제가 된다. 
		String[]arr = splitStr.split(":",3); //3개로 구분하고 싶다, 
		for(String score:arr) {
			System.out.println(score);
		}
		
		
		splitStr = "90::80";  //수학시험은 응시하지 않았다. 
		System.out.println("점수들=" + splitStr);
		arr = splitStr.split(delim,3); //3개로 구분하고 싶다, 
		for(String score:arr) {
			System.out.println(score);
		}
		System.out.println("--StringTokenizer--");
		String stStr = "90:100:80";
		System.out.println("점수들=" + stStr);
		StringTokenizer st = new StringTokenizer(stStr, delim);
		while(st.hasMoreTokens()) {
			String score = st.nextToken();
			System.out.println(score);
		}
		stStr = "90::80";
		System.out.println("점수들=" + stStr);
		st = new StringTokenizer(stStr,delim);
		while(st.hasMoreTokens()) {
			String score = st.nextToken();
			System.out.println(score);
		}

		
		
		

		String urlStr = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%9E%90%EB%B0%94";
		//파싱은 해석한다는 것. \
		//문자열 구조를 해석할 것이다. 
		//URL, URI   //HTTP/HTTPS프로토콜, 정규표현식 
		int index1 = urlStr.indexOf(":");
		if(index1 > -1) {
			String protocol = urlStr.substring(0, index1); //0~index1-1 
			System.out.println(protocol);
			
		}
		
		delim = "\\?";//정규표현식에는 ?문법이 있다. 구분자인지 정규표현식 문법인지 모호해진다. 
		//물음표와 알려주려면 \\주면 됨. 
		urlStr.split(delim,2);
		for(String urlS:arr) {
			System.out.println(urlS);
		}
		
			
				
			
			
	}		
			
		}
			
			
			
		
		
	



