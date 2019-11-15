package sample2;
public class Exec{
  public static void main(String[] args){
    Dice d = new Dice(); //オブジェクトを生成
    d.n = 1;
    d.size = "L";
    d.play(); //playメソッド
    System.out.println(d.n);
    System.out.println(d.size);
  }
}
