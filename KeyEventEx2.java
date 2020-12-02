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
		move.addKeyListener(new KeyListener() { // 익명클래스 (내부클래스의 한 종류)
			@Override
			public void keyTyped(KeyEvent e) {} // keyTyped : 대소문자 가린다
			@Override
			public void keyReleased(KeyEvent e) {}// keyReleased : 대소문자 못 가린다
			@Override
			public void keyPressed(KeyEvent e) {//keyPressed : 대소문자 못 가린다
				int code=e.getKeyCode();
				String txt = KeyEvent.getKeyText(code);
				//System.out.println(code+" : " + txt); // 컴터에서는 윗방향키는 -로 향함, 아래방향키는 +로 향함
				int x = move.getX();
				int y = move.getY();
				if(txt.equals("Right")) {
					if(x>getWidth()-50) {return;} // 창 밖으로 못나가게 범위설정
					x+=10;
				}else if(txt.equals("Left")) {
					if(x<0) {return;} // 창 밖으로 못나가게 범위설정
					x-=10;
				}else if(txt.equals("Up")) {
					if(y<30) {return;} // 창 밖으로 못나가게 범위설정
					y-=10;
				}else if(txt.equals("Down")) {
					if(y>getHeight()-50) {return;} // 창 밖으로 못나가게 범위설정
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
