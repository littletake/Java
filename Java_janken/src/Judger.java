/*
判断アルゴリズム
出ている手の数をtypeHand[]というフラグで整理して勝ち負けを判断している。
*/
import java.util.List;

/*package-private*/
class Judger {
    static void flagJudge(List<Player0> playerList) {
        int i;
        int peopleNum = playerList.size();
//        [あいこになっているか否か(0:あいこ, 1:あいこではない), "0"になっている手の種類]
        int[] infoJudge = new int[]{0, 0};

        int[] hand = new int[peopleNum];
        int[] typeHand = new int[3];
        for (i = 0; i < peopleNum; i++) {
            hand[i] = playerList.get(i).getHand();
            typeHand[hand[i]]++;
        }

        if (typeHand[0] == 0) {
            if (typeHand[1] == 0 || typeHand[2] == 0) {
                infoJudge[0] = 0;
            } else {
                infoJudge[0] = 1;
            }
        } else if (typeHand[1] == 0) {
            if (typeHand[0] == 0 || typeHand[2] == 0) {
                infoJudge[0] = 0;
            } else {
                infoJudge[0] = 1;
                infoJudge[1] = 1;
            }
        } else if (typeHand[2] == 0) {
            if (typeHand[0] == 0 || typeHand[1] == 0) {
                infoJudge[0] = 0;
            } else {
                infoJudge[0] = 1;
                infoJudge[1] = 2;
            }
//            あいこのとき
        } else {
//            なにもしない
        }

//        次に勝ち点を追加
        int winHand, notHand; //notHand = 誰も出していない手の種類
        int score; //得点
        int consecutiveNum; // 連勝・連敗数
        notHand = infoJudge[1];

        if (infoJudge[0] == 1) {
//        勝ちの手と負けの手を決定
            if (notHand == 0) {
                winHand = 1;
            } else if (notHand == 1) {
                winHand = 2;
            } else {
                winHand = 0;
            }

//            勝者には加点、敗者には減点
            for (i = 0; i < peopleNum; i++) {
//                勝者の場合(連勝数によって得点が異なる)
                if (playerList.get(i).getHand() == winHand) {
                    consecutiveNum = playerList.get(i).getConsecutiveNum();
                    if(consecutiveNum >= 0) {
                        consecutiveNum++;
                    } else {
                        consecutiveNum = 1;
                    }
                    playerList.get(i).setConsecutiveNum(consecutiveNum);
                    score = Option.scoreRule(consecutiveNum, 1) + playerList.get(i).getWinNum();
                    playerList.get(i).setWinNum(score);
//                敗者の場合
                } else {
                    consecutiveNum = playerList.get(i).getConsecutiveNum();
                    if(consecutiveNum <= 0){
                        consecutiveNum--;
                    } else {
                        consecutiveNum = -1;
                    }
                    playerList.get(i).setConsecutiveNum(consecutiveNum);
                    score = Option.scoreRule(consecutiveNum * -1, -1) + playerList.get(i).getWinNum();
                    playerList.get(i).setWinNum(score);
                }
            }
//            あいこのとき
//            勝ち数は変更せず、全員の連勝数・連敗数を0にする
        } else {
            for(i = 0; i < peopleNum; i++){
                playerList.get(i).setConsecutiveNum(0);
            }
        }
    }
}
