//じゃんけんのプレイヤーを定義するクラス
public class Player {
    //フィールド変数
    private int hand; //出す手
    private int winNum; //勝ち数

    //コンストラクタ
    public Player(){
        this.hand = 0;
        this.winNum = 0;
    }

    //ゲッター作成
    public int getHand(){
        return hand;
    }
    public int getWinNum(){
        return winNum;
    }

    //セッター作成
    public void setHand(int hand){
        this.hand = hand;
    }
    public void setWinNum(int winNum){
        this.winNum = winNum;
    }

    //Player1の出す手のアルゴリズム
    public void randomMethod(){
        hand = RandomMethod.jankenMethod();
    }

    //Player2の出す手のアルゴリズム
    public void loopMethod(int i){
        hand = LoopMethod.jankenMethod(i);
    }
}
