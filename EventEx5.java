package ch17;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx5 extends MFrame 
implements ItemListener{
	
	Checkbox pink, green, yellow;
	CheckboxGroup g;
	
	public EventEx5() {
		g= new CheckboxGroup();
		Panel p = new Panel();
		p.add(pink = new Checkbox("pink",g,true));
		p.add(green = new Checkbox("green",g,false));
		p.add(yellow = new Checkbox("yellow",g,false));
		add(p,BorderLayout.SOUTH);
		pink.addItemListener(this);
		green.addItemListener(this);
		yellow.addItemListener(this);
		setBackground(Color.PINK); //실행시 첫 화면창에 나타나는 색깔 세팅
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 방법 1-----------------------------------------------------------
		Object obj = e.getSource();
		if(obj==pink) {// 객체를 비교하는 == 는 객체의 주소값!!!을 비교하는 것이다!!!!!
			setBackground(Color.PINK);
		}else if(obj==green) {
			setBackground(Color.GREEN);
		}else if(obj==yellow) {
			setBackground(Color.YELLOW);
		}
		// 방법2---------------이방법 많이 쓴다.-----------------------------------
		//3개 전부가 Checkbox 타입이라서 가능하다, 3개 선택권이 각각 다르다면 Checkbox 사용 못함
		Checkbox cb = (Checkbox)e.getSource(); 
		if(cb.getLabel().equals("pink")) {
			setBackground(Color.PINK);
		}else if(cb.getLabel().equals("green")){
			setBackground(Color.GREEN);
		}else if(cb.getLabel().equals("yellow")){
			setBackground(Color.YELLOW);
		}
	}
	
	public static void main(String[] args) {
		new EventEx5();
	}
}