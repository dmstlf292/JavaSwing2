package ch17;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventEx2 extends MFrame{
	
	Button move;
	
	public KeyEventEx2() {
		super(400, 500, new Color(100,200,100));
		setLayout(null);
		move = new Button("move");
		move.setBounds(200, 250 , 50 ,30);
		move.addKeyListener(new KeyListener() { // �͸�Ŭ���� (����Ŭ������ �� ����)
			@Override
			public void keyTyped(KeyEvent e) {} // keyTyped : ��ҹ��� ������
			@Override
			public void keyReleased(KeyEvent e) {}// keyReleased : ��ҹ��� �� ������
			@Override
			public void keyPressed(KeyEvent e) {//keyPressed : ��ҹ��� �� ������
				int code=e.getKeyCode();
				String txt = KeyEvent.getKeyText(code);
				//System.out.println(code+" : " + txt); // ���Ϳ����� ������Ű�� -�� ����, �Ʒ�����Ű�� +�� ����
				int x = move.getX();
				int y = move.getY();
				if(txt.equals("Right")) {
					if(x>getWidth()-50) {return;} // â ������ �������� ��������
					x+=10;
				}else if(txt.equals("Left")) {
					if(x<0) {return;} // â ������ �������� ��������
					x-=10;
				}else if(txt.equals("Up")) {
					if(y<30) {return;} // â ������ �������� ��������
					y-=10;
				}else if(txt.equals("Down")) {
					if(y>getHeight()-50) {return;} // â ������ �������� ��������
					y+=10;
				}
				move.setLocation(x, y);
				
				/*
				 * @Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				String txt = KeyEvent.getKeyText(code);
				//System.out.println(code + " : " + txt);
				int x = move.getX();
				int y = move.getY();
				if(txt.equals("Right")) {
					x+=10;
				}else if(txt.equals("Left")) {
					x-=10;
				}else if(txt.equals("Up")) {
					y-=10;
				}else if(txt.equals("Down")) {
					y+=10;
				}
				
				if(x < 0) {
					x = 0;
				} else if (x > 400-50) {
					x = 350;
				}
				
				if(y < 30) {
					y = 30;
				} else if (y > 500-30) {
					y = 470;
				}
				move.setLocation(x, y);
				
			}*/
				
				
			}
		});
		add(move);
		move.requestFocus();
		validate();
	}
	public static void main(String[] args) {
		new KeyEventEx2();
	}
}
