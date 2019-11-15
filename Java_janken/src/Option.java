import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

/*package-private*/
class Option {
//        参加者の数とプレイヤーの戦略選択
    static void decidePlayer(List<Player0> playerList) {
        int i;
        int[] peopleNumFlag = new int[2];
        Player0 player;

//        エラー処理
        do {
            processInputError(peopleNumFlag);
        }while(peopleNumFlag[1] == -1);

//        人数分のインスタンスを生成（list）
        for (i = 0; i < peopleNumFlag[0]; i++) {
            player = chooseTypePlayer(i);
            player.setName("player" + Integer.toString(i + 1));
            playerList.add(player);
        }
    }

//    入力のエラー処理
    private static void processInputError(int[] peopleNumFrag) {
        Scanner scan = new Scanner(System.in);
        int peopleNum = 0;
        int error = 0;

        System.out.println("参加者の人数を決定して下さい:");
        try {
           peopleNum = scan.nextInt();
        } catch (InputMismatchException e) {
           System.out.println("ERROR: 自然数を入力してください!");
           System.out.println();
           error = -1;
        }
        peopleNumFrag[0] = peopleNum;
        peopleNumFrag[1] = error;
    }

    //    ここでプレイヤーの出す手のアルゴリズムを選択する。

    private static Player0 chooseTypePlayer(int num) {
        Player0 player;
//        mod3でループ,ランダム,リビューの順でセット
//        if (num % 3 == 0) {
//            player = new LoopPlayer();
//        } else if (num % 3 == 1) {
//            player = new RandomPlayer();
//        } else {
//            player = new ReviewPlayer();
//        }
//        mod3でグーだけ,パーだけ,チョキだけの順でセット
        if (num % 3 == 0) {
            player = new OnlyGuPlayer();
        } else if (num % 3 == 1) {
            player = new OnlyTyokiPlayer();
        } else {
            player = new OnlyPaPlayer();
        }
        return player;
    }

    //    点数のルール設定
//    勝ち：+連勝率の二乗
//    負け：-min(2^{連勝率-1}, 1000000)
//    あいこ：0
    static int scoreRule(int consecutiveNum, int winFlag) {
        int score;
        if (winFlag == 1) {
            score = (int) Math.pow(consecutiveNum, 2);
        } else if (winFlag == -1) {
            score = (int) Math.min(Math.pow(2, consecutiveNum - 1), 1000000) * -1;
        } else {
            score = 0;
        }
        return score;
    }

    //    勝敗の特別ルール設定
//    あるプレイヤーの勝ち数が、
//    １．20000点を超えるとき
//    ２．−100000000点(10億)を下回るとき
//    強制終了
    static int forceEnd(List<Player0> playerList) {
        int peopleNum = playerList.size();
        int i;
        int score;
        int error = 0;

        for (i = 0; i < peopleNum; i++) {
            score = playerList.get(i).getWinNum();
            if (score < -100000000 || 20000 < score) {
                error = -1;
            }
        }
        return error;
    }
}
