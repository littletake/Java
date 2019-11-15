package sample2;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class MenuFrame extends JFrame implements ActionListener {
    private JFrame menuFrame;
    private Container contentPane;
    private JPanel labelPanel;
    private JPanel listPanel;
    private JPanel buttonPanel;
    private JLabel menuLabel;
    private JLabel buttonLabel;
    private JList<String> fileList;
    private JButton checkButton;
    private String path = "./src/img";
    private File dir;
    private String[] files;

    MenuFrame() {
        this.dir = new File(this.path);
        this.files = this.dir.list();
        this.menuFrame = new JFrame("Menu");
        this.menuFrame.setSize(600, 600);
        this.menuFrame.setLocationRelativeTo((Component)null);
        this.menuFrame.setDefaultCloseOperation(3);
        this.contentPane = this.menuFrame.getContentPane();
        this.labelPanel = new JPanel();
        this.menuLabel = new JLabel("The Menu of Albums");
        this.menuLabel.setFont(new Font("Arial", 0, 30));
        this.labelPanel.add(this.menuLabel);
        this.contentPane.add(this.labelPanel, "North");
        this.fileList = new JList(this.files);
        this.fileList.setFont(new Font("Arial", 0, 30));
        JScrollPane sp = new JScrollPane();
        sp.getViewport().setView(this.fileList);
        sp.setPreferredSize(new Dimension(500, 300));
        this.listPanel = new JPanel();
        this.listPanel.add(sp);
        this.contentPane.add(this.listPanel, "Center");
        this.buttonLabel = new JLabel();
        this.buttonLabel.setFont(new Font("Arial", 0, 30));
        this.checkButton = new JButton("check");
        this.checkButton.setFont(new Font("Arial", 0, 30));
        this.checkButton.addActionListener(this);
        this.checkButton.setActionCommand("checkButton");
        this.buttonPanel = new JPanel();
        this.buttonPanel.add(this.buttonLabel);
        this.buttonPanel.add(this.checkButton);
        this.contentPane.add(this.buttonPanel, "South");
        this.menuFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        StringBuffer sb = new StringBuffer();
        if (actionCommand.equals("checkButton")) {
            if (this.fileList.isSelectionEmpty()) {
                sb.append("Empty");
            } else {
                sb.append((String)this.fileList.getSelectedValue());
            }

            this.buttonLabel.setText(new String(sb));
        }
    }
}
