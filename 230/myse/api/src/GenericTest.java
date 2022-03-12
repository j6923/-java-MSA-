import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		List<String> list;   //<>를 제내릭이라고 한다. 즉 요소들의 제내릭이라고 한다. //element generic
		//요소의 자료형을 결정해준다. 
		list = new ArrayList<>();
		list.add("Hello");
		list.add(new String("제내릭"));
//		list.add(new Integer(1));   //다른 자료형은 저장할 수 없다. 
		String s = list.get(0);   
		for(String s1:list) {
			//String타입으로 각 요소를 하나씩 꺼내올 수 있다. 
		}

	}

}
