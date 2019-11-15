//これをplayerの原型として他の形を作成する。
//abstractクラスの注意点
//・直接インスタンスができない
//・抽象化したメソッドは必ずオーバーライドしなければならない
//・サブクラスで必ずコンストラクタを記述しなければならない。

//インターフェイスの場合、多重継承が可能になるということ。
import java.util.ArrayList;
import java.util.List;
abstract class Player0 {
    //フィールド変数
    private String name; //名前
    private int hand; //出す手
    private List<Integer> handData; //出した手のデータを保存するリスト
    private int winNum; //勝ち数
    private int consecutiveNum; //正：連勝数, 負：連敗数


    //コンストラクタ
    /*package-private*/
    Player0(){
        this.name = null;
        this.hand = 0;
        this.handData = new ArrayList<>();
        this.winNum = 0;
        this.consecutiveNum = 0;

    }

    /*package-private*/
    //ゲッター作成
    String getName(){
        return name;
    }
    int getHand(){
        return hand;
    }
    int getWinNum(){
        return winNum;
    }
//    int getHandData(int num){
//        return handData.get(num);
//    }
    int getConsecutiveNum() {
        return consecutiveNum;
    }


    //セッター作成
    void setName(String name){
        this.name = name;
    }
    void setHand(int value){
        this.hand = value;
    }
    void setWinNum(int winNum){
        this.winNum = winNum;
    }
    void setHandData(){
        this.handData.add(this.hand);
    }
    void setConsecutiveNum(int consecutiveNum) {
        this.consecutiveNum = consecutiveNum;
    }

//    同じ名前で引数有と引数なしのメソッドが作れる。
//    でも、今回は抽象化を使うためコメントアウト
    //abstract void jankenMethod();

    abstract void jankenMethod(int i, List<Player0> playerList);
}
