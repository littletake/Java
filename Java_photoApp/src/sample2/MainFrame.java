//import java.awt.Component;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//class MainFrame extends JFrame {
//    private String[] panelNames = new String[]{"menuPanel", "photoPanel"};
//    private MenuPanel menuPanel;
//    private PhotoPanel photoPanel;
//
//    MainFrame() {
//        this.menuPanel = new MenuPanel(this, this.panelNames[0]);
//        this.photoPanel = new PhotoPanel(this, this.panelNames[1]);
//        this.setSize(600, 600);
//        this.setLocationRelativeTo((Component)null);
//        this.setDefaultCloseOperation(3);
//        this.add(this.menuPanel);
//        this.menuPanel.setVisible(true);
//        this.add(this.photoPanel);
//        this.photoPanel.setVisible(false);
//    }
//
//    void changePanels(JPanel jp, String str) {
//        System.out.println(jp.getName());
//        String name = jp.getName();
//        if (name.equals(this.panelNames[0])) {
//            this.menuPanel = (MenuPanel)jp;
//            this.menuPanel.setVisible(false);
//        } else if (name.equals(this.panelNames[1])) {
//            this.photoPanel = (PhotoPanel)jp;
//            this.photoPanel.setVisible(false);
//        }
//
//        if (str.equals(this.panelNames[0])) {
//            this.menuPanel.setVisible(true);
//        } else if (str.equals(this.panelNames[1])) {
//            this.photoPanel.setVisible(true);
//        }
//
//    }
//}
