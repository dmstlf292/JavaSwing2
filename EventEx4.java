package ch17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx4 extends MFrame
implements ActionListener{
	
	Button red, blue;
	
	public EventEx4() {
		Panel p = new Panel();
		p.add(red = new Button("red"));
		p.add(blue = new Button("blue"));
		add(p,BorderLayout.SOUTH);
		red.addActionListener(this); // label - red
		blue.addActionListener(this);// label - blue
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.toString());
		// ActionEvent 객체를 만든 장본인 소스(컴포넌트)는 누군데?     e.getSorce();    &   매개변수 타입은 Object obj
		Object obj = e.getSource(); // e를 꺼내서 비교
		if(obj==red) {
			setBackground(Color.RED);
		}else if(obj==blue){
			setBackground(Color.BLUE);
		}
	}

	public static void main(String[] args) {
		new EventEx4();
	}
}
