//過去の手のデータを利用して手を出すplayer

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*package-private*/
class ReviewPlayer extends Player0 {
    ReviewPlayer(){
        super();
    }

//    自分の一つ前の手に勝つ手を出すアルゴリズム
//    public void jankenMethod(int presentTime) {
//        int pastHand;
//        int nextHand;
//        if (presentTime > 0) {
//            pastHand = getHandData(presentTime - 1);
//        } else {
//            pastHand = 0;
//        }
//        nextHand = JudgeHand(pastHand);
//        setHand(nextHand);
//    }

//    引数の手に勝つ手を出すメソッド
//    private int JudgeHand(int hand){
//        int nextHand;
//        if(hand == 0){
//            nextHand = 2;
//        } else if(hand == 1){
//            nextHand = 0;
//        } else {
//            nextHand = 1;
//        }
//        return nextHand;
//    }

//    5回目以降は今までの回数で一番勝数の多いプレイヤーの手をコピーするアルゴリズム。
    void jankenMethod(int presentTime, List<Player0> playerList) {
        List<Player0> NowPlayerList = new ArrayList<>(playerList);
        int nowWinnerHand;

        if (presentTime < 4) {
            int hand;
            hand = presentTime % 3;
            setHand(hand);
        } else {
            Collections.sort(NowPlayerList, new MyComp());
//            確認用
//            for(i = 0; i < peopleNum;i++) {
//                System.out.printf("%s, ", NowPlayerList.get(i).getName());
//            }
//            System.out.println();
            nowWinnerHand = NowPlayerList.get(0).getHand();
            setHand(nowWinnerHand);
        }
    }
}


