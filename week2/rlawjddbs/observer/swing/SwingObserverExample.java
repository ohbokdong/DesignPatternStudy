package week2.observer.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame frame;

	public static void main(String args[]) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	} // main

	public void go() {
		frame = new JFrame();
		JButton button = new JButton("정말 해도 될까?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	} // go

	class AngelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("안 돼. 분명 나중에 후회할 거야.");
		}

	} // AngerListener

	class DevilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("당연하지. 그냥 저질러 버려!");
		}
	} // DevilListener
} // class
