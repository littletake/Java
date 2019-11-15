package myApp;

import javax.swing.*;

public class MainFrame extends JFrame {
    //Panelの種類
    private Menu menuPanel;
    private Photo photoPanel;

//    private PhotoTest_2 photoPanel2;

    MainFrame() {
        //frameの設定
        this.setTitle("APP");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //パネルの選択
        //最初はメニュー画面のみ
        this.menuPanel = new Menu(this);
        this.menuPanel.setVisible(true);

        this.setVisible(true); //これが先に必要
    }

    //menu画面でアルバムが選択されたらスライドショーする
    //frame部分、menu画面で選択したアルバム名、切り替え時間の3つを引数としてインスタンス生成
    void changePanel(String name, int time){
        this.createBufferStrategy(2);
        this.photoPanel = new Photo(this, name, time);
        this.menuPanel.repaint(); //スライドショーの終了後にメニュー画面に遷移するために必要
    }
}
