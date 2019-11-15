package myApp;

import javax.swing.*;
import java.awt.BorderLayout;

public class Test extends JFrame{

    public static void main(String[] args){
        Test frame = new Test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 150, 150);
        frame.setTitle("タイトル");
        frame.setVisible(true);
    }

    Test(){
        ImageIcon icon = new ImageIcon("./src/img/pic3.png");
        JLabel label = new JLabel(icon);

        JPanel p = new JPanel();
        p.add(label);

        getContentPane().add(p, BorderLayout.CENTER);
    }
}