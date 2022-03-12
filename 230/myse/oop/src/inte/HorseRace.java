package inte;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
 * 이벤트 프로그램 처리순서
 * 1. 이벤트소스와 이벤트 종료결정 ex: 이벤트소스-btReady, 이벤트 종류 - ActionEvent 
 * 2. 이벤트 핸들러 작성(이벤트 발생했을 때 할 일을 작성) 
 * 		class MyReadyHandler implements ActionListener{
 * 			public void actionPerformed(ActionEvent e){
 * 				System.out.println("준비버튼이 클릭되었습니다");
 *          }
 *       }
 * 3. 이벤트 소스와 이벤트핸드러를 연결
 * 		MyReadyHandler eh = new MyReadyHandeler();
 * 		btReady.addActionListener(eh); 
 */

class MyReadyHandler implements ActionListener{
	JTextField jt; 
	MyReadyHandler(JTextField jt){
		this.jt = jt;
	}
//	int readyClickCnt = 0; 
	public void actionPerformed(ActionEvent e){
//		System.out.println("준비버튼이 클릭되었습니다");
//		readyClickCnt++;   //
		jt.setText("준비버튼이 클릭되었습니다.");
		
	}
}  


public class HorseRace {
	JFrame jf; //프레임   //창을 하나만든다 액자를 하나 만든다고 생각해도 된다. 
	JTextField jt; //한 줄 입력란 
	JButton btStart; //달려버튼
	JButton btReady; //준비버튼
	
	 /* 내부(Inner)클래스 
	 * 외부(Outer) 클래스 mf와 method를 모두 사용할 수 있다.  
	 
	 */
//	class MyStartHandler implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			jt.setText("달리기 시작되었습니다.");
//			//jt에 "달리기ㅣ작되었습니다." 설정 
//		}  //클래스 안에 클래스가 존재하는 경우이다.
//		// 재사용성 떨어져 
//		// 내부 클레스, 중첩 클래스, 
//	}
//	
	
	public HorseRace() {
		jf = new JFrame("달리기");//프레임(액자)생성   //다른 언어에서는 window창만들기라고도 한다.  객자의 타이틀이 달리기 
		jt = new JTextField();  //hint : 값설정하려면 jt.setText("hello"); 값얻기하려면 String s = jt.getText();
		// 텍스트 필드에 출력되게 하려면 
		btStart = new JButton("달려");   //버튼 두개를 만듦 // 버튼의 타이틀이 달려 
		btReady = new JButton("준비");    // 타이틀은 준비 
		Container c = jf.getContentPane(); //프레임뒷판  //교실 뒤에 있는 게시판같은 것를 변경한다고 생각하면 됨. // 액자 뒷판이라고 생각하면 됨. 
		c.setLayout(new GridLayout(3,1)); //프레임의 레이아웃을 2행1열로 설정 어떻게 배치할 지 결정하면 됨. 
		c.add(jt);
		c.add(btReady);  //버튼 두개를 추가  첫번째 추가한 내용이 첫번째 행에 들어감 
		c.add(btStart);   //
		
		
		MyReadyHandler eh = new MyReadyHandler(jt);
		btReady.addActionListener(eh);
		
//		MyStartHandler eh1 = new MyStartHandler();
//		btReady.addActionListener(eh);
		
//		MyStartHandler eh1 = new MyStartHandler(jt);
		// 익명클래스 객체 생성 
//		btStart.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//jt에 "달리기시작되었습니다"설정
//				jt.setText("달리기 시작되었습니다");// 이름 없는 클래스라고 부른다. 
//			}
//		});
		
		
		//람다식을 사용한 익명클래스 객체생성
				btStart.addActionListener((e)-> {
					//jt에 "달리기시작되었습니다"설정
					jt.setText("달리기 시작되었습니다");			
				});

		
		jf.setSize(400, 200); //프레임의 크기설정 가로400픽셀, 세로200픽셀  //프레임에   //프로그램 종료하고 싶다고 해보았자 x박스 클릭하면 프로그램 자동 종료는 아니다. 
		//화면에서 ㅏ라진 것이지 강제로 빨간 터미네이터 버튼  눌러야 한다. 
		jf.setVisible(true);//화면에 보여주기   //화면에 보여주려고 true값을 준다. 
	}
	public static void main(String[] args) {
		new HorseRace();
	}
}
