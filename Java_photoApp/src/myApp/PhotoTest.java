package myApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


//class PhotoTest {
//    BufferStrategy bstrategy;
//    //Fileクラスのオブジェクトを生成する
//    private String pathName = "./src/photo/";
//    private File dir = new File(pathName);
//    //listFilesメソッドを使用して一覧を取得する
//    private File[] list = dir.listFiles();
//    private List<BufferedImage> imageList = new ArrayList<BufferedImage>();
//
//
//    PhotoTest() {
//        JFrame frame = new JFrame("MyWindow");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setSize(600, 600);
//        frame.setLocationRelativeTo(null);
//        frame.setIgnoreRepaint(true);
//        frame.createBufferStrategy(2);
//        bstrategy = frame.getBufferStrategy();
////        Graphics graphics = bstrategy.getDrawGraphics();
//
//        //画像の読み込み
//        //画像がうまく表示できるように調整
//        String imgPath;
//        int i = 0;
//        BufferedImage dst;
//        Graphics graphics = bstrategy.getDrawGraphics();
//        while (i < list.length) {
//            imgPath = "../photo/" + list[i].getName();
//            System.out.println(imgPath);
//            try {
//                imageList.add(ImageIO.read(getClass().getResource(imgPath)));
//                imageList.set(i, scaleImage(imageList.get(i), 600, 400));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (!bstrategy.contentsLost()) {
//                graphics.translate(0,0);
//                graphics.drawImage(imageList.get(i), 0, 0, frame);
//                bstrategy.show();
//
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                i++;
//            }
//        }
//        graphics.dispose();
//    }
//
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
//}