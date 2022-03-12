
public class Array1 {

	public static void main(String[] args) {
//		int sal1=41; //1월 급여 
//		int sal2=25;
//		int sal3=25;
//		int sal4=33;
//		int sal5=44;
//		int sal6=55; //6월 급여 
		int[] sal; // int[]sal  //배열선언
		sal = new int[6];  //배열 생성 
		sal[0] = 41; 
		sal[1] = 25; 
		sal[2] = 25;
		System.out.print("1월급여:" + sal[0]);
		System.out.print("2월급여:" + sal[1]);
		System.out.println("6월급여:" + sal[5]);//0
//		System.out.println("0월급여:" + sal[-1]);  //error 발생   
		//c는 배열의 크기는 sizeof 
		
		System.out.println("배열길이:"+sal.length); //6  //length() 아님 
		// 배열초기화: 배열 선언,생성, 대입을 한 번에 할 수 있습니다.    >> 이것을 하는 절차 
		int[]arr = {1,3,5}; // ,로 각 값을 넣는 것을 초기화라고 함. 0번 인덱스 1 1번인덱스에 3, 2인덱스에 5 
		System.out.println(arr[0]); //1
		System.out.println(arr[2]); //5
		System.out.println(arr.length); //3 
		
		//동일 데이터 타입의 자료형 묶음이어서 int, string, boolean타입이 섞여서 들어갈 수 없음을 주의하자 
		
		sal[2] = 25; sal[3] = 33; sal[4] = 44;  sal[5] = 55; 
//		int salTotal = sal[0]+sal[1]+sal[2]+sal[3]+sal[4]+sal[5]; //반복문으로 바꿀 수 있다. 
		int salTotal = 0; //초기화 
		int monthCnt = sal.length; //한번만 계산해서 해주고 이미 계산된 변수값하고 비교함. 
		for(int index=0; index<monthCnt; index++) {//6대신에 sal.length를 쓰는 것을 더 권장한다. 
			salTotal += sal[index];
		}
		double salAvg = salTotal / 6.0; //(double)salTotal/6; 
		//첫번쨰처럼 쓰는게 더 좋음 
		//double으로 미리 고정하는 것과 int타입을 강제 형변환하는 것을 비교하면 전자가 더 좋음. 
//		System.out.println(salAvg);
		System.out.println("상반기 총급여="+salTotal);
		System.out.println("상반기 평균급여=" + salAvg);
		
// 2. 계산을 해서 배열의 값을 넣어보자. 
		int []arr1 = new int[10];  //뱌열 선언 및 초기화 
		int arrLength=arr1.length;
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4; 
		arr1[4] = 5;
		arr1[5] = 6;
		arr1[7] = 7; 
		arr1[8] = 8; 
		
		for(int index1=0;index1<arr1.length; index1++) {
			arr1[index1] = index1+1; 
			System.out.println(arr1[index1] + "\t");
		}
		System.out.println();

	}

}
