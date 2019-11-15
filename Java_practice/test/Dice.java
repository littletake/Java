package sample2;
public class Dice {
  int n;
  String size;

  public Dice(int m, String s){ //コンストラクタの生成
    n = m;
    size = s;
  }
  void play(){
    n = (int)(Math.random()*6) + 1;
  }
}
