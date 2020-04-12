package week2.rlawjddbs.observer.swing;

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
		JButton button = new JButton("���� �ص� �ɱ�?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	} // go

	class AngelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("�� ��. �и� ���߿� ��ȸ�� �ž�.");
		}

	} // AngerListener

	class DevilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("�翬����. �׳� ������ ����!");
		}
	} // DevilListener
} // class
