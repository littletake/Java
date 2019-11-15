//JListを使って一覧を出力するpanel
package myApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class Menu extends JPanel implements ActionListener{
    private MainFrame frame;
    private JList jList;
    private JTextField text;
    private JLabel errorLabel;
    private JButton checkButton;
    //アルバムのディレクトリ取得
    private String path = "./src/albumFile/";
    private String albumPath;
    private File dir = new File(path);

    //キーボードでの操作
    private boolean spaceKey = false;

    //コンストラクタ
    Menu(MainFrame frame){
        this.frame = frame;
        Container contentsPane = frame.getContentPane();

        //ラベル作成
        JPanel topPanel = new JPanel(); //上部の全体的なコンポーネント
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(800, 70));
        JLabel menuLabel = new JLabel("Please Choose an Album");
        errorLabel = new JLabel();

        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        errorLabel.setForeground(Color.RED);

        topPanel.add(menuLabel, BorderLayout.NORTH);
        topPanel.add(errorLabel, BorderLayout.CENTER);
        topPanel.setVisible(true);
        this.add(topPanel, BorderLayout.NORTH);

        //リストパネルの作成
        jList = new JList<String>(dir.list());
        jList.setFont(new Font("Arial", Font.PLAIN, 30));
        JScrollPane sp = new JScrollPane();
        sp.getViewport().setView(jList);
        sp.setPreferredSize(new Dimension(400, 200));
        this.add(sp, BorderLayout.CENTER);

        //ボタンパネルの作成
        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new BorderLayout());
        checkButton = new JButton("Check");
        checkButton.setFont(new Font("Arial", Font.PLAIN, 30));
        checkButton.setMnemonic(KeyEvent.VK_C);
        checkButton.addActionListener(this);
        checkButton.setActionCommand("checkButton");

        //切り替え時間記入欄の作成
        text = new JTextField(2);
        text.setText("0");
        text.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel timeLabel = new JLabel("Slide Time[s]: ");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        buttonPanel.add(timeLabel);
        buttonPanel.add(text);
        buttonPanel.add(checkButton);
        buttonPanel.setVisible(true);
        this.add(buttonPanel, BorderLayout.SOUTH);

        contentsPane.add(this);
    }

    //ボタンが押された時の動作
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //ファイルのパス
        String path;
        StringBuffer sb = new StringBuffer();
        //切り替え時間
        int time;
        if (actionCommand.equals("checkButton")) {
            dualWithError(sb);
        }
    }

    //エラー処理と画面遷移
    private void dualWithError(StringBuffer sb){
        String str = text.getText();
        //切り替え時間が記入されていない場合(初期値のまま)
        if(str.equals("0")) {
            sb.append("ERROR: Write SlideTime!!");
            errorLabel.setText(new String(sb));
        } else if(!isNum(str)){
        //切り替え時間の記入が数字以外の場合
            sb.append("ERROR: Write NUMBER!!");
            errorLabel.setText(new String(sb));
        } else if (jList.isSelectionEmpty()) {
            //アルバムが選択されていない場合
            sb.append("ERROR: Choose Album!!");
            errorLabel.setText(new String(sb));
        }else{
            sb.append(jList.getSelectedValue());
            errorLabel.setText("");
            text.repaint();
            checkButton.repaint();
            albumPath = new String(sb);
            //アルバム内の写真がない場合
//            path = path + albumPath;
//            File images = new File(albumPath);
//            File[] list = images.listFiles();
//            System.out.println(list.length);
            this.frame.changePanel(albumPath, Integer.parseInt(str) * 1000); //ここでミリ秒変換しておく
        }
    }

    //入力値が数字か否かを判定する
    private boolean isNum(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}