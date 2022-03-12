package world.asia;
/**
 * 접근제어자(Access Modifier)
 * public - 누구나 접근 가능, class/mf(멤버필드)/consructor(생성자)/method 
 * default(아무런 접근제어자도 선언 안 됨) - 동일 패키지에서 접근 가능, class/mf(멤버필드)/consructor(생성자)/method 
 * private - 자기 클래스에서 접근 가능, mf/constructor/method 
 * 
 * @author KOSTA
 *
 */
public class Korea {
	public String capital; 
	String language;
	private int population;
	public void setPopulation(int population) {
		if(population < 1) {
				System.out.println("인구는 0이상이어야 한다.");
		}else {
			this.population = population; //그 값일 경우만 접근할 수 있도록 함. 
			//객체의 멤버 필드에 접근할 수 있게 함. 
		}
	}
	public int getPopulation() {  //get 메서드 
		return population;
	}

}
