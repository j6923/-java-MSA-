public class Array2 {

	public static void main(String[] args) {
		//배열 초기화 
		int[]arr = {1,2,3,4};
		//배열 초기화는 선언과 생성을 같이 해줄 수 있음. 
		// 초기화는 값을 새로 초기화하지 못함 
		//예를 들어서 
		//arr = {0,1}; //이렇게 재초기화불가   //배열 재초기화 안됨. 
		//강제로 재초기화하고 싶다ㅗㄱ 하면 
		arr = new int[] {0,1};//이렇게 해야지 배열 재초기화가 됨. 
		
		char[]alpha = new char[5];
		alpha[0]='A';
		alpha[1]='B';
		alpha[2]='C';
		alpha[3] = 'D';
		alpha[4] = 'E';
		
		for(int i =0; i<alpha.length; i++) {
			alpha[i] = (char)('A'+i);  //더하기 연산을 만나면 int 보다 작은 타입은 int타입으로 자동 형변환 됨. //int가 되어버림 
			
		}
		for(int i =0; i<alpha.length; i++) {
			System.out.print(alpha[i]);  
			System.out.println(i+"-" + alpha[i]+ ",");  //0A 1B 2C
		}
		System.out.println();
		
		arr = new int[] {1, 4, 3, 2, 10, 4, 2, 7, 3, 1, 1}; //각 숫자의 출현쇳수를 세주세요. 
		// 각 숫자의 출현횟수를 출력하시오. 
		//1회 출현횟수 : 1 
		// 2의       : 2
		// 3의       : 2 
		// 4의       : 2 
		// 5의       : 0 
		// 6의       : 0
		// 7의       : 1 
		// 8의       : 0 
		// 9의       :0
		// 10의      :1 
		
		int cntArr[] = new int[10]; //출현횟수가 저장될 배열 
		                            //cntArr[0]는 1의 출현횟수가 저장될 공간 
		                            //cntArr[1]는 2의 "            " 배열 반복수행하면서 각 인덱스 값이 cntArr의 각 방에 플러스 되면 됨. 
		                            //cntArr[3]는 4의 '""		
		
		//int num = arr[0]-1;
		//cntArr[num]++; 
		for(int i = 0; i<arr.length; i++) {
			int num = arr[i];   //i:0, num:1,    i:1, num:4
			cntArr[num-1]++;  //, cntArr[1-1]++;    cntArr[4-1]++;   
					
		}
		
		for(int i=0; i<cntArr.length; i++) {
			System.out.println((i+1) + "의 출현횟수:" + cntArr[i]);
		}
		
		
		//로또숫자: 1~45사이의 중복되지 않는 숫자 6개 만들기 
		int[]lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			//이전숫자들과 현재숫자가 같은 경우: 중복된 경우 
			//j가 0번방에서부터 현재 방 전까지 현재 방에 있는 숫자와 이전방에 있는 숫자를 비교 
			lotto[i] = (int)(Math.random()*45)+1; //1<= (int)(r*45)  <46   //숫자가 중복될 수 있다. //그래서 중복되었는지 중복되지 않았는지 확인해줘야 함. 
	    
			for(int j=0; j<i; j++) {
				if(lotto[j] == lotto[i]);
			}
		}	
		//값이 서로 중복되지 않도록 안 ㅗㄱ에서 
		for(int i =0; i<lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		
		
		//2차원 배열 
		//배열 표기 
		char[][]star;
		star = new char[5][];
//		star[0]= new char[1];
//		star[1] = new char[2];
//		star[2] = new char[3];
//		star[3] = new char[4]; 
//		star[4] = new char[5];
		
		for(int i=0; i<star.length; i++) {
			star[i] = new char[i+1];
		}
			
		
//		star[0][0] = '*';
//		star[1][0] = '*';
//		
//		star[2][0] = '*';
//		star[2][1] = '*';
//		star[2][1] = '*';
//		
//		star[3][0] = '*';
//		star[3][1] = '*';
//		star[3][2] = '*';
//		star[3][3] = '*';
//		
//		star[4][0] = '*';
//		star[4][1] = '*';
//		star[4][2] = '*';
//		star[4][3] = '*';
//		star[4][4] = '*';
		for(int row=0; row<star.length; row++) {
			for(int col=0; col<star[row].length; col++) {
				star[row][col] = '*';  //행별 열 수 만큼 지정함. 
			}
		}
		for(int row=0; row<star.length; row++) {
			for(int col=0; col<star[row].length; col++) {
				System.out.print(star[row][col]);
				
			}
			System.out.println();
		}
		
		//행별 고정해서 할 수도 있음. 
		int[][]arr2= new int[3][3]; //행별 열수를 고정해서 씀 
//		arr2[0][0] =1; 
//		arr2[0][1] =2; 
//		arr2[0][2] =3;
//		
//		arr2[1][0] = 4;
//		arr2[1][1] = 5;
//		arr2[1][2] = 6;
//		
//		arr2[2][0] = 7; 
//		arr2[2][1] = 8;
//		arr2[2][2] = 9;
		System.out.println("------------------------------------");
//		for(int row=0, col=0; row<arr2.length && col<arr2.length; row++, col++) { 
////			for(int col = 0; col<arr2.length;col++) {
//				System.out.println(arr2[row][col]);
//			}
		int num =1;   //3 이면 밑에 num+=3하면 됨. 
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length;col++) {
				arr2[row][col] = num;  //arr2[row][col] = num++; 
				num++;  //num--;   //3의 배수 num*=3; 
			}
		}
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {
				System.out.print(arr2[row][col]);
			}
			System.out.println();
		}
		
		//배열로 최대값, 최소값 구하기, 정렬하기(종류, 특징, 구현: 선택정렬, 버블정렬)  //사빕정렬 
		int[]arr3= {4, 8, 3, 7, 2, 5};	
		int maxNum= 0;
//		if(arr3[0]>maxNum) {
//			maxNum=arr3[0];
//		}
//		if(arr[1]>maxNum) {
//			maxNum=arr3[1];
//		}
//		if(arr[2]>maxNum) {
//			maxNum=arr3[2];
//		}
		for(int i=0; i<arr3.length; i++) {
			if(maxNum < arr3[i]){
				maxNum = arr3[i];
			}
		}
		System.out.println("최대값:" + maxNum);
		

	
	java.util.Arrays.sort(arr3); //오름차순 정렬용 라이브러리 
	for(int i=0; i<arr3.length; i++) {
		System.out.println(arr3[i]);
	}
	
	}
	
}
		
