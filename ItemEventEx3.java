package ch17;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventEx3 extends MFrame 
implements ItemListener{
	
	Choice air, city;
	String sair[] = {"대한항공","아시아나","에어부산"};
	String scity[] = {"서 울","대 전","대 구","부 산","제주도"};
	TextArea ta;
	
	public ItemEventEx3() {
		super(300,300,new Color(100,200,100)); // 영역에 색 세팅하기
		Panel p = new Panel();
		air = new Choice();
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		for (int i = 0; i < scity.length; i++) {
			city.add(scity[i]);
		}
		p.add(air);
		p.add(city);
		add(p,BorderLayout.NORTH);
		
		add(ta=new TextArea());
		city.addItemListener(this);
		validate();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//if구문 사용해서 ta에 선택한 리스트들의 내용들을 보이게 하기
		if(e.getSource()==city) {
			
			String str = "선택한 항공사 : " ;// 선택한 항공사 : ㅇㅇ항공
			//str뒤에 "+" 기호 안붙여주면 항공사이름은 안나오고 목적지만 화면 출력된다.
			str+=air.getSelectedItem() ;  // 선택한 항공사 : ㅇㅇ항공
			////////////////////////////////////////////////////////////
			str+="\n선택한 도시 : ";// 선택한 도시 : ㅇㅇ
			str+=city.getSelectedItem();// 선택한 도시 : ㅇㅇ
			////////////////////////////////////////////////////////////
			ta.setText(str);
		}
	}

	public static void main(String[] args) {
		new ItemEventEx3();
	}
}




