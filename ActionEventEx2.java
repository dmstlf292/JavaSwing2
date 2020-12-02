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
	String lab[] = {"�߰�","�����","��ü�����","����"};
	TextField tf; // Ű���� �Է½� keyEvent, �� ������ Ÿ���� �� �߰���ư ������ �Ǵ� Ÿ���� �� enter ������ �����Ǵ� ��ɸ����

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
	public void actionPerformed(ActionEvent e) { // ��ư4���� cmd�� ����!
		String cmd = e.getActionCommand();
		if(cmd.equals(lab[0]) || tf ==e.getSource()) { // �����̺�Ʈ : �߰� �Ǵ� Ű�̺�Ʈ : ����ġ�� �ԷµǴ� �̺�Ʈ 
			String item = tf.getText(); //�Էµ� ���ڿ� ����
			if(item.trim().length()==0) {// �Է��� �� ���� �����̶�� , trim ���� ���Ž�Ű�� ��� 
				tf.setText("");
				tf.requestFocus();
				setTitle("���ڿ��� �Է��ϼ���.");
				// �ݺ������� ���������� ��� break ...�޼ҵ忡�� return�� ���������� ���********************if-else ��� ���ϰ�!!
				return;// �޼ҵ� ��ü�� ���������� ��� : return, list�� ������ (add�ϴ°�) �ȵȴ�. 
			}		
			list.add(item); // list�� �Էµ� ���ڿ� �߰��ϱ�
			tf.setText(""); // ������ �ʱ�ȭ ��Ų��. // �ڸ��� �����ϰ� ���� ���°� -> ���ڸ� �Է��ϼ��� 
			tf.requestFocus(); // ��Ŀ���� �����´�. 
		}else if(cmd.equals(lab[1])) {
			int idx = list.getSelectedIndex();
			 //indexOf�� ����, ������ �ȵǾ������� null���� �ƴ϶� (�������� �̹� ���ֱ� ������ null���� �ƴ�)-1��° ���� ���� �Ǿ�����. 
			if(idx==-1) {
				setTitle("������ �������� �����ϼ���");
				return;
			}
			list.remove(idx);			
		}else if(cmd.equals(lab[2])) {
			list.removeAll();//�߰��� ��� ������ ����, ��ü �����//
		}else if(cmd.equals(lab[3])) {
			System.exit(0);// �ý��� ����, �ȿ� ���� ���ڴ� �ǹ̰� ����. �Ϲ������� 0���� �Է�
		}
	}
	public static void main(String[] args) {
		new ActionEventEx2();
	}
}

