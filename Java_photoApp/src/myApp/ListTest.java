//JListについて調べるためのクラス
//JListのaddには注意
//JListのパネルとbuttonのパネルは違くなってる。だから、setVisibleの調整がうまくいってない。
package myApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//class ListTest extends JPanel implements ActionListener {
//    private JList list;
//    private JLabel label;
//    JPanel listPanel;
//
//    //ディレクトリ取得
//    private String path = "./src/img/";
//    private File dir = new File(path);
//    //一覧取得
//    private String[] fileList = dir.list();
//
//    ListTest(MainFrame frame){
//        Container contentsPane = frame.getContentPane();
//        /* JListの初期データ */
////        String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
//
//        list = new JList<String>(fileList);
//        list.setFont(new Font("Arial", Font.PLAIN, 30));
//
//        //リストパネルの作成
////        listPanel = new JPanel();
//        JScrollPane sp = new JScrollPane();
//        sp.getViewport().setView(list);
//        sp.setPreferredSize(new Dimension(400, 200));
//        this.add(sp);
//        contentsPane.add(this, BorderLayout.CENTER); //ここが原因みたい
//
//        //ボタンパネルの作成(表示付き)
//        JPanel buttonPanel = new JPanel();
//        label = new JLabel();
//        JButton checkButton = new JButton("Check");
//        checkButton.addActionListener(this);
//        checkButton.setActionCommand("checkButton");
//
//        buttonPanel.add(checkButton);
//        buttonPanel.add(label);
//        buttonPanel.setVisible(false);
//        this.add(buttonPanel);
//        contentsPane.add(buttonPanel, BorderLayout.SOUTH);
//    }
//
//    public void actionPerformed(ActionEvent e){
//        String actionCommand = e.getActionCommand();
//
//        StringBuffer sb = new StringBuffer();
//
//        if (actionCommand.equals("checkButton")){
//            if (list.isSelectionEmpty()){
//                sb.append("Empty");
//            }else{
//                sb.append(list.getSelectedValue());
//            }
//        }else{
//            return;
//        }
//
//        label.setText(new String(sb));
//    }
//}