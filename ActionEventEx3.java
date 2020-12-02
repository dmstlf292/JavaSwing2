package ch17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx3 extends MFrame implements ActionListener{

	List list;
	Button b[] = new Button[4];
	String lab[] = {"�߰�","�����","��ü�����","����"};
	TextField tf; // Ű���� �Է½� keyEvent, �� ������ Ÿ���� �� �߰���ư ������ �Ǵ� Ÿ���� �� enter ������ �����Ǵ� ��ɸ����
	
	public ActionEventEx3() {
		super(300,200);
		setTitle("ActionEx3");
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
	public void actionPerformed(ActionEvent e) { // ��ư4���� cmd�� ����!
		String cmd = e.getActionCommand();
		if(cmd.equals(lab[0]) || tf ==e.getSource()) { // �����̺�Ʈ : �߰� �Ǵ� Ű�̺�Ʈ : ����ġ�� �ԷµǴ� �̺�Ʈ 
			String item = tf.getText(); //�Էµ� ���ڿ� ����
			if(item.trim().length()==0) {// �Է��� �� ���� �����̶�� , trim ���� ���Ž�Ű�� ��� 
				MDialog md = new MDialog(this, "�˸�","���ڿ��� �Է��ϼ���");//���ų� �˸�â �ߴ±��!!!
				int width = 180;
				int height = 100;
				int px = getX();
				int py = getY();
				int x = px+getWidth()/2-width/2;
				int y = py+getHeight()/2-height/2;
				md.setBounds(x, y, width, height);
				md.setVisible(true);
				return; // �߿�, �ݺ��� ���������°� break + �޼ҵ� ���������°� return
			}
			list.add(item); // list�� �Էµ� ���ڿ� �߰��ϱ�
			tf.setText(""); // ������ �ʱ�ȭ ��Ų��. // �ڸ��� �����ϰ� ���� ���°� -> ���ڸ� �Է��ϼ��� 
			tf.requestFocus(); // ��Ŀ���� �����´�. 
		} else if(cmd.equals(lab[1])) {
			int idx = list.getSelectedIndex();
			 //indexOf�� ����, ������ �ȵǾ������� null���� �ƴ϶� (�������� �̹� ���ֱ� ������ null���� �ƴ�)-1��° ���� ���� �Ǿ�����. 
			if(idx==-1) {// ������ �ȵǾ�������
				MDialog md = new MDialog(this, "�˸�","������ �������� �����ϼ���");
				int width = 180;
				int height = 100;
				int px = getX();
				int py = getY();
				int x = px+getWidth()/2-width/2;
				int y = py+getHeight()/2-height/2;
				md.setBounds(x, y, width, height);
				md.setVisible(true);
				return; // �߿�
			}
			list.remove(idx);
		}else if(cmd.equals(lab[2])) {
			list.removeAll();//�߰��� ��� ������ ����, ��ü �����//
		}else if(cmd.equals(lab[3])) {
			System.exit(0);// �ý��� ����, �ȿ� ���� ���ڴ� �ǹ̰� ����. �Ϲ������� 0���� �Է�
		}
	}
	class MDialog extends Dialog implements ActionListener{ //-----------1���� ����
		
		Button btn;

		public MDialog(Frame f, String title, String msg) {
			super(f,title,true);
			setLayout(new FlowLayout()); // FlowLayout�� ��������?
			add(new Label(msg, Label.CENTER)); //��ü Label�� ��� ����Ǿ��ִ°�?
			add(btn = new Button("Ȯ��"));
			btn.addActionListener(this);
		}//----MDialog ��	
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();//MDialog�� �������.
		}
	}//---ActionListener ��
	public static void main(String[] args) {
		new ActionEventEx3();
	}

}

