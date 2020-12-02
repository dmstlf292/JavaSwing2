package ch17; // �� ������ ���� �߿��ϴ�!!!!!!!!!!!!

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventEx1 extends MFrame implements ActionListener{ //-----(1)
	/*�̺�Ʈ ����� 3�� ���
	 1. �̺�Ʈ �ҽ�
	 2. �̺�Ʈ Ŭ���� : �̺�Ʈ �ҽ��� Ŭ�� �Ǵ� üũ, �������� �̺�Ʈ�� �߻��ϸ� ��������� �̺�Ʈ ��ü
	 		ex) ActionEvent �� ǥ�� �ִ�.
	 3. �̺�Ʈ �ڵ鷯 : �̺�Ʈ �ҽ�(��ư)�� �̺�Ʈ Ŭ������ 2�� ������ �ϱ� ���ؼ� interface�� �ϳ� ������ �ؾ��Ѵ�. 
	 						 �� interface�� �̸��� XXXListener��� ���������� -> ActionListener (����ó�� �������־ �ϱ��ϱ�)
	 3-1.  �������̺�Ʈ : ��ư�� Ŭ���ϸ� ��Ÿ���� �̺�Ʈ -> interface �̸� : itemListener			
	 */
	
	Button btn; // <---�̺�Ʈ �ҽ�, ��ư�� Ŭ���ϸ� ActionEvent�� �޸𸮻󿡼� ���� �Ⱥ������� �׼��̺�Ʈ ��ü�� �޸��忡 �ڵ����� ���� : �̸� ������ ��. 

	public EventEx1() {
		add(btn = new Button("��ư"), BorderLayout.SOUTH);
		//4. �̺�Ʈ �ҽ��� �̺�Ʈ �ڵ鷯�� ���� : ���´� addXXXListener
		//ch.addItemListener............. tx.addKeyListener (textArea)
		btn.addActionListener(this);// 5. �� ���� �ϼ��� �����ϱ� -----(4)
	}
	
	//�̺�Ʈ �ڵ鷯 =  �׼Ǹ������� interface �Ǵ� �������̵� �ؾ��� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) { // ȭ���� ��ư�� Ŭ���ϸ� �� �޼ҵ尡 ȣ��ǰԲ� �ϴ� �ڵ鷯 ------(2)
		setBackground(MColor.rColor()); //------(3)
	}

	public static void main(String[] args) {
		new EventEx1();
	}
}
