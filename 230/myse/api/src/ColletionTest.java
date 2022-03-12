import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ColletionTest {
	
	public static void test(Collection c) {
		c.add("One");
		c.add(new Integer(2));  //Object 타입으로 upcasting됨. 
		c.add(3);  //int는 Object타입으로 upcasting불가 
					//Autoboxing됨. 컴파일시
					//컴파일시 c.add(new Integer(3));로 변환됨. 
		c.add(new Integer(2));
		
		System.out.println("저장된 요소 개수: " + c.size());
		System.out.println("저장된 요소들");
		for(Object o:c) {
			System.out.println(o);  //o.toString()자동 호출됨. 
		}
		
	}
	public static void test(Map m) {
		m.put("One", "first"); //첫번쨰 인자는 키이고 다음값은 값이다. 
		m.put(new Integer(2), "second");
		m.put(3, "third");
		m.put(new Integer(2), "forth");  // 키들을 일부러 중복시켜보았다. 
		//키들이 중복 허용도 되지 않고 순서도 
		System.out.println("맴에 저장된 요소 개수: " + m.size());
		System.out.println("저장된 요소들");
		//Map은 키와 벨류 저장되어다 보니까 출력할 때 일단은 키들만 꺼내오고 키에 해당하는 값을 다시 찾아와야 한다. 
		Set keys =m.keySet();//맴의 키들만 얻는 작업
		for(Object k:keys) {
			Object v = m.get(k);
			m.get(k);  //get매서드를 이용해서 키를 찾아온다. 
			System.out.println(k+":"+ v);  
			//요소 삭제는 remove로 삭제 절차 진행하면 된다. 
		}
	}
	public static void main(String[] args) {
		
		Collection c;
//		c = new Collection(); //컬렉션은 인터페이스여서 직접 new 키워드로 객체 생성하는 애가아니다. 
		c=new ArrayList();
		test(c);
		
		c = new HashSet();//set계열이어서 인덱스가 없다 
		test(c);
		
		Map m;
		m = new HashMap();
		test(m);  //map과 collection관계는 서로 상속관계가 없어서 upcasting불가하다. 

	}

}
