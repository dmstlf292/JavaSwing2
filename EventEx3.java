package ch17; // this�� ������� �ʰ� �̺�Ʈ �����ϱ�, �̷��Դ� ��� ����

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx3 extends MFrame {
	
	Button btn; 

	public EventEx3() {
		add(btn = new Button("��ư"), BorderLayout.SOUTH);
		//�̺�Ʈ �ҽ��� �̺�Ʈ �ڵ鷯(MyAction ����)
		MyAction ma= new MyAction(); // ---3
		btn.addActionListener(ma); // ---2 & 4 (this ��� ma)
	}
	
	//����Ŭ���� ---1
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) { // actionPerformed�� �Ű������� ActionEvent
		setBackground(MColor.rColor());
		}
	}

	public static void main(String[] args) {
		new EventEx3();
	}
}




