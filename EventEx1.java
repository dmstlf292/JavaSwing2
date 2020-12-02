package ch17; // 이 예제가 가장 중요하다!!!!!!!!!!!!

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx1 extends MFrame implements ActionListener{ //-----(1)
	/*이벤트 기능의 3대 요소
	 1. 이벤트 소스
	 2. 이벤트 클래스 : 이벤트 소스를 클릭 또는 체크, 여러가지 이벤트를 발생하면 만들어지는 이벤트 객체
	 		ex) ActionEvent 는 표에 있다.
	 3. 이벤트 핸들러 : 이벤트 소스(버튼)랑 이벤트 클래스랑 2개 연결을 하기 위해서 interface를 하나 구현을 해야한다. 
	 						 그 interface의 이름이 XXXListener라고 정해져있음 -> ActionListener (공식처럼 정해져있어서 암기하기)
	 3-1.  아이템이벤트 : 버튼을 클릭하면 나타나는 이벤트 -> interface 이름 : itemListener			
	 */
	
	Button btn; // <---이벤트 소스, 버튼을 클릭하면 ActionEvent가 메모리상에서 눈에 안보여지는 액션이벤트 객체를 메모장에 자동으로 생성 : 미리 정해진 것. 

	public EventEx1() {
		add(btn = new Button("버튼"), BorderLayout.SOUTH);
		//4. 이벤트 소스랑 이벤트 핸들러를 연결 : 형태는 addXXXListener
		//ch.addItemListener............. tx.addKeyListener (textArea)
		btn.addActionListener(this);// 5. 이 문구 완성후 실행하기 -----(4)
	}
	
	//이벤트 핸들러 =  액션리스너의 interface 또는 오버라이딩 해야할 메소드
	@Override
	public void actionPerformed(ActionEvent e) { // 화면의 버튼을 클리하면 이 메소드가 호출되게끔 하는 핸들러 ------(2)
		setBackground(MColor.rColor()); //------(3)
	}

	public static void main(String[] args) {
		new EventEx1();
	}
}
