package ch17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx2 extends MFrame implements ActionListener{

	List list;
	Button b[] = new Button[4];
	String lab[] = {"추가","지우기","전체지우기","종료"};
	TextField tf; // 키보드 입력시 keyEvent, 이 영역에 타이핑 후 추가버튼 눌리면 또는 타이핑 후 enter 누르면 생성되는 기능만들기

	public ActionEventEx2() {
		super(300,200);
		//////////////////////////////////////////////
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		for (int i = 0; i < b.length; i++) {
			p.add(b[i]=new Button(lab[i]));
			b[i].addActionListener(this);
		}
		//////////////////////////////////////////////
		add(list=new  List());
		add(p,"East");
		add(tf=new TextField(),"South");
		tf.addActionListener(this);
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼4개는 cmd로 구분!
		String cmd = e.getActionCommand();
		if(cmd.equals(lab[0]) || tf ==e.getSource()) { // 엑션이벤트 : 추가 또는 키이벤트 : 엔터치면 입력되는 이벤트 
			String item = tf.getText(); //입력된 문자열 리턴
			if(item.trim().length()==0) {// 입력을 한 값이 공백이라면 , trim 빈값을 제거시키는 기능 
				tf.setText("");
				tf.requestFocus();
				setTitle("문자열을 입력하세요.");
				// 반복문에서 빠져나오는 기능 break ...메소드에서 return은 빠져나오는 기능********************if-else 사용 안하고!!
				return;// 메소드 전체를 빠져나가는 기능 : return, list가 실행이 (add하는것) 안된다. 
			}		
			list.add(item); // list에 입력된 문자열 추가하기
			tf.setText(""); // 빈값으로 초기화 시킨다. // 자리만 차지하고 값은 없는것 -> 문자를 입력하세요 
			tf.requestFocus(); // 포커스를 가져온다. 
		}else if(cmd.equals(lab[1])) {
			int idx = list.getSelectedIndex();
			 //indexOf의 문법, 선택이 안되어있으면 null값이 아니라 (정수값이 이미 들어가있기 때문에 null값은 아님)-1번째 값이 선택 되어진다. 
			if(idx==-1) {
				setTitle("삭제할 아이템을 선택하세요");
				return;
			}
			list.remove(idx);			
		}else if(cmd.equals(lab[2])) {
			list.removeAll();//추가된 모든 아이템 삭제, 전체 지우기//
		}else if(cmd.equals(lab[3])) {
			System.exit(0);// 시스템 종료, 안에 들어가는 숫자는 의미가 없다. 일반적으로 0으로 입력
		}
	}
	public static void main(String[] args) {
		new ActionEventEx2();
	}
}

