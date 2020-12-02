package ch17;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventEx1 extends MFrame implements ItemListener{
	
	Label label; // 체크박스 밑에 현 체크상황을 알려주는 레이블
	Checkbox cb1, cb2, cb3;
	
	public ItemEventEx1() {
		super(200, 200);
		// FlowLayout : 왼쪽에서 오른쪽으로 차례차례 쌓이며, 내가 선택한 정렬로 정렬이 된다.
		setLayout(new FlowLayout());
		add(cb1=new Checkbox("수박"));
		add(cb2=new Checkbox("바나나"));
		add(cb3=new Checkbox("멜론"));
		add(label = new Label("현재 상태 :"));
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		validate();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//객체를 발생시킨 이벤트 소스(컴포넌트)를 리턴한다. 
		//객체주머니는 object타입(getSource 클릭해서 소스 보기)
		//call by reference = 객체의 주소값을 넘겨주는것, 수박체크하면 cb1이라는 객체의 주소값, 다시 공부하기
		Checkbox cb = (Checkbox)e.getSource(); 
		String str = cb.getLabel() + ":" + cb.getState(); // 화면에서 현재상태 : -> 여기에서 박스 클릭시 바나나:true...이런식으로 나타남
		label.setText(str);
		setTitle(str);
			
	}
	public static void main(String[] args) {
		new ItemEventEx1();
	}
}




