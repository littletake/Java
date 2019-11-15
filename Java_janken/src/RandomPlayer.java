//サブクラスでもしっかりコンストラクタは作ること。
//ランダムに手を出す
//継承を使ってみた

import java.util.List;

/*package-private*/
class RandomPlayer extends Player0{
    //コンストラクタ
    /*package-private*/
    RandomPlayer(){
        super();
    }

    void jankenMethod(int i, List<Player0> playerList){
        int value;
        value = (int)(Math.random() * 10);
        value = value % 3;
        setHand(value);
    }
}
