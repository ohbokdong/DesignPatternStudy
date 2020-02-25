package week8.minj0i;

import java.awt.Graphics;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "내가 최고!";
		graphics.drawString(msg, 100, 100);
	}
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("헤드 퍼스트 디자인 패턴");
	}
}
