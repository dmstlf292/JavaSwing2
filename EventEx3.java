package ch17; // this를 사용하지 않고 이벤트 실행하기, 이렇게는 사용 안함

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx3 extends MFrame {
	
	Button btn; 

	public EventEx3() {
		add(btn = new Button("버튼"), BorderLayout.SOUTH);
		//이벤트 소스랑 이벤트 핸들러(MyAction 연결)
		MyAction ma= new MyAction(); // ---3
		btn.addActionListener(ma); // ---2 & 4 (this 대신 ma)
	}
	
	//내부클래스 ---1
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) { // actionPerformed의 매개변수는 ActionEvent
		setBackground(MColor.rColor());
		}
	}

	public static void main(String[] args) {
		new EventEx3();
	}
}




