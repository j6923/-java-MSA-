package abst;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar now; //서로 다른 패키지에 있어서 
		//now = new Calendar();  //추상클래스여서 new 키워드로 객체 생성 불가하다. 
		now = Calendar.getInstance();  //이렇게 해야 캘린더 타입 반환받을 수 있음. 
		//getInstance는 public으로 되서 누구나 접근 가능 
//		now = new GregorianCalendar();
		System.out.println(now.getClass().getName());  //now참조 점수의 이름을 반환 . 실제 사용되는 객체 이름을 반환한다. 
		System.out.println(now); //now.toString()호출됨.  
		int year = now.get(Calendar.YEAR); // 컴퓨터의 연도를 반환해준다. 
		int month = now.get(Calendar.MONTH); //final필드여서 month는 변경불가함. //월-1 
		System.out.println("년도:" + year);  //2021 
		System.out.println("월:" + (month+1));  // 9 0부터 먼저 나와서 +1이 나오게 된다. 
		//월 91이 출력된다.    문자열 + 1이어서 91이 됨. 
		// 다른 문자열하고 문자열 결합 연산이 될 수 있으므로 주의하자. 
		System.out.println("년도:" + year);
		System.out.println("웖:" + (month+1));
		System.out.println("일:"+ now.get(Calendar.DATE));
		System.out.println("시:" + now.get(Calendar.HOUR_OF_DAY));
		System.out.println("분:" + now.get(Calendar.MINUTE));
		System.out.println("초:" + now.get(Calendar.SECOND));
		// 달력에 관련된 요일에 관한 정보도 얻을 수 있고 이 달 말일이 몇일 인지 얻을 수 있다. 
		// 요일 얻을 때는 
		int day = now.get(Calendar.DAY_OF_WEEK); //금요일이면 6을 반환 
		//프랑스는 월요일부터 보임. 달력이 
		// 프랑스권 달력은 월요일부터 시작 
		//사용하는 OS가 어떤 것인가에 따라서 월요일이 가장 앞 일요일이 가장 끝일 수도 있다. 
		// 고정화 시키지 않기 
//		if(day==1) {} //좋은 방법이 아니다. day of week의 상수가 sunday..... 이어서
		switch(day) {
		case Calendar.SUNDAY:
			System.out.println("일요일");
			break;
		case Calendar.MONDAY:
			System.out.println("월요일");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일");
			break;
		default:
			System.out.println("토요일");
		}
			
		}

	}


