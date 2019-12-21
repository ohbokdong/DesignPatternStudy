package week2.younggeun0;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
    JFrame frame;
    
    public static void main(String[] args) {
        SwingObserverExample soe = new SwingObserverExample();
        soe.go();
    }

    public void go() {
        frame = new JFrame();
        JButton button = new JButton("정말 해도 될까?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    class AngelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("안돼 너 분명 후회할거야");
        }
    }
    
    class DevilListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("당연하지. 그냥 저질러버려");
        }
    }
}