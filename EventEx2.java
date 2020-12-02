package ch17;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx2 extends MFrame implements ItemListener{ 
	/*체크박스는 -> XXXListener의 ItemListener 사용한다*/

	Checkbox cb;
	//체크 이벤트가 발생되면 배경색 -> 랜덤으로 구현하기

	public EventEx2() {
		add(cb=new Checkbox("체크"), BorderLayout.SOUTH );
		//이벤트소스.addXXXListener 
		// 여기서 this는 내 자신을 가르키는 keyword -> 내 자신의 객체 주소이다!!!!!
		cb.addItemListener(this); // 체크박스 체크 또는 해제했을때 -> itemStateChanged 호출
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx2();
	}
}

