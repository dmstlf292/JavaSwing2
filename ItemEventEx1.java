package ch17;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventEx1 extends MFrame implements ItemListener{
	
	Label label; // üũ�ڽ� �ؿ� �� üũ��Ȳ�� �˷��ִ� ���̺�
	Checkbox cb1, cb2, cb3;
	
	public ItemEventEx1() {
		super(200, 200);
		// FlowLayout : ���ʿ��� ���������� �������� ���̸�, ���� ������ ���ķ� ������ �ȴ�.
		setLayout(new FlowLayout());
		add(cb1=new Checkbox("����"));
		add(cb2=new Checkbox("�ٳ���"));
		add(cb3=new Checkbox("���"));
		add(label = new Label("���� ���� :"));
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		validate();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//��ü�� �߻���Ų �̺�Ʈ �ҽ�(������Ʈ)�� �����Ѵ�. 
		//��ü�ָӴϴ� objectŸ��(getSource Ŭ���ؼ� �ҽ� ����)
		//call by reference = ��ü�� �ּҰ��� �Ѱ��ִ°�, ����üũ�ϸ� cb1�̶�� ��ü�� �ּҰ�, �ٽ� �����ϱ�
		Checkbox cb = (Checkbox)e.getSource(); 
		String str = cb.getLabel() + ":" + cb.getState(); // ȭ�鿡�� ������� : -> ���⿡�� �ڽ� Ŭ���� �ٳ���:true...�̷������� ��Ÿ��
		label.setText(str);
		setTitle(str);
			
	}
	public static void main(String[] args) {
		new ItemEventEx1();
	}
}




