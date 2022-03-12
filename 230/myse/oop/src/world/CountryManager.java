package world;
import world.asia.Korea;  // 이것을 사용하겠다. //best 
import world.europe.France;
// c에서의 include와 다르다. 자바는 전처리가 없어 약간 다르다. 
// c에서의 include와 자바의 import는 유사한 의미이다. 
// 이렇게 간략하게 적을 수 있다. 
import world.asia.Japen;  //world.asia.Japan을 상ㅇ하겠다. 
//import는 패키지 아래에 적는다. 
//위의 2개의 import 구문은 import world.asa.*;로 사용가능하다.   //
//*를 쓴다고 메모리를 더 많이 차지 하는 것이 아니다. 
// 전체 다 씀. 
// 그러나 각각 import 쓰는 것을 권장하고 *하는 것을 권장하지 않는다. 

//import java.util.Date;   //import java.util.Scanner;
//import java.sql.Date; 가 있는데      // import java.sql.Date; 
// 사용시 Date d = new Date();한다면 어느 패키지의 것인지 모호해진다.  >> 컴파일이 안된다. 
// * 로 쓴다면 
// Scanner sc = new Scanner(System.in);
//Date d  = new Date(); 
// 다른 사람이 소스코드를 볼 때도 어떤 것의 data인지 모른다. 즉 코드가 명확해지지 않는다. 
public class CountryManager {

	public static void main(String[] args) {
		//country 쪽에서 korea 사용하도록 함. 
//		world.asia.Korea k; //Korea 타입의 k 변수를 선언하려고 함. 
//		// 패키지명.클래스명
//		k = new world.asia.Korea();  //이때도 패키지명을 적어줘야 한다. 
		// 코리아 타입 객테를 100개 만들어야 한다면 패키지명도 같이 써야 해서 불편하다. 
		Korea k;
		k = new Korea(); //이렇게 하고 		
		
		Japen j = new Japen();
		France f = new France(); 
		
		// ctrl+space bar 누르면 자동으로 입력이 된다 
		// ctrl shift o 
		
		//객체 생성 후에 사용하기 
		k.capital = "평양"; //잘못된 값  //멤버 변수가 어떤 차이가 있길래 되는 경우 있고 안 되는 경우 있고  
		k.language = "중국어";  //한국어이지 중국어가 아니여서 잘못된 값 
//		k.population = -1;   //이것도 잘못된 값 >> 일부러 혹은 실수로 
		// 적절치 않은 값 대입되려고 하면 대입 못하도록 컴파일 에러 발생 
		//public이면 무조건 값 대입이 됨. 
		// language 와 population은 선
		//protected 상태 package상태 default 상태라고 한다. 
		//접근 제어자 혹은 접근 제한자라고 한다. 
		k.setPopulation(5000);
	}

}
