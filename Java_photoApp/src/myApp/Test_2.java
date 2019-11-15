package myApp;

import java.awt.*;
import javax.swing.*;

class panel1 extends JPanel{

    JButton jb1;

    panel1(){
        //ボタンの作成
        jb1 = new JButton("Hello");

        //レイアウトの指定
        setLayout(new BorderLayout());
        //JPanelの配置

        add(jb1,BorderLayout.CENTER);

    }
}
class panel2 extends JPanel{

    JButton jb2;

    panel2(){
        //ボタンの作成
        jb2 = new JButton("Java");

        //レイアウトの指定
        setLayout(new BorderLayout());
        //JPanelの配置

        add(jb2,BorderLayout.CENTER);

    }
}

public class Test_2{
    public static void main(String args[]){

        panel1 jb_app = new panel1();
        panel2 jb_app1 = new panel2();

        JFrame jf = new JFrame("JButton");

        Container contentPane = jf.getContentPane();

        contentPane.add(jb_app,BorderLayout.NORTH);
        contentPane.add(jb_app1,BorderLayout.SOUTH);

        jf.setSize(200, 200);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


