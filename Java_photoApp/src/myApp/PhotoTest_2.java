////画像をスライドショーするpanel
//
//package myApp;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//class PhotoTest_2 extends JPanel{
//
//    // コンストラクタ生成
//    PhotoTest_2(MainFrame frame, String path, int time){
//        String albumPath, imgPath;
//        int i = 0;
//        List<BufferedImage> imageList = new ArrayList<BufferedImage>();
//        ImageIcon icon;
//
//        Container contentsPane = frame.getContentPane();
//
//        //listFilesメソッドを使用して一覧を取得する
//        albumPath = "./src/albumFile/" + path;
//        File images = new File(albumPath);
//        File[] list = images.listFiles();
//
//        //画像の読み込み
//        while(i < list.length) {
//            imgPath = albumPath + "/" + list[i].getName();
//            System.out.println(imgPath); //確認用(コマンドに写真のパス表示)
//
//            icon = new ImageIcon(imgPath);
//            JLabel photoLabel = new JLabel(icon); //画像表示用
//            this.add(photoLabel, BorderLayout.CENTER);
//            contentsPane.add(this, BorderLayout.CENTER);
//            try {
//                Thread.sleep(time);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i++;
//        }
//
////            try{
////                imageList.add(ImageIO.read(getClass().getResource(imgPath)));
////                imageList.set(i, scaleImage(imageList.get(i), 600, 500));
////            } catch (IOException e){
////                e.printStackTrace();
////            }
////            if (!strategy.contentsLost()) {
////                graphics.translate(0,0);
////                graphics.drawImage(imageList.get(i), 0, 0, frame);
////                strategy.show();
////
////                try {
////                    Thread.sleep(time);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                i++;
////                System.out.println(i);
////            }
////            if(exitKey){
////                System.out.println("PUSH");
////                break;
////            }
////        }
//    }
//
//    //画面サイズに合わせる
//    private BufferedImage scaleImage(BufferedImage src, int destWidth, int destHeight) throws IOException {
//
//        int width = src.getWidth();    // オリジナル画像の幅
//        int height = src.getHeight();  // オリジナル画像の高さ
//
//        // 縦横の比率から、scaleを決める
//        double widthScale = (double) destWidth / (double) width;
//        double heightScale = (double) destHeight / (double) height;
//        double scale = widthScale < heightScale ? widthScale : heightScale;
//
//        ImageFilter filter = new AreaAveragingScaleFilter(
//                (int) (src.getWidth() * scale), (int) (src.getHeight() * scale));
//        ImageProducer p = new FilteredImageSource(src.getSource(), filter);
//        Image dstImage = Toolkit.getDefaultToolkit().createImage(p);
//        BufferedImage dst = new BufferedImage(
//                dstImage.getWidth(null), dstImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
//        Graphics2D g = dst.createGraphics();
//        g.drawImage(dstImage, 0, 0, null);
//        g.dispose();
//        return dst;
//    }
//
//
//    //キーボードでの動作
////    public void keyTyped(KeyEvent e) {
////        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
////            exitKey = true;
////            System.out.println("PUSH");
////        }
////    }
////    public void keyPressed(KeyEvent e) {
////        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
////            exitKey = true;
////            System.out.println("PUSH");
////        }
////    }
////    public void keyReleased(KeyEvent e) {
////        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
////            exitKey = false;
////        }
////    }
//
////    //ボタンが押された時の動作
////    public void actionPerformed(ActionEvent e) {
////        String actionCommand = e.getActionCommand();
////        if (actionCommand.equals("checkButton")) {
////            this.changePanel();
////        }
////    }
//}
