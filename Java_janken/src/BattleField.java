//全体の流れを表している。
import java.util.Collections;
import java.util.List;

/*package-private*/
class BattleField {
    //    main
    static void mainJudge(List<Player0> playerList, int runtime) {
        int i, j;
        int peopleNum = playerList.size();

        for (i = 0; i < runtime; i++) {
            for (j = 0; j < peopleNum; j++) {
                playerList.get(j).jankenMethod(i, playerList);
                playerList.get(j).setHandData();
            }
//            フラグを用いた判断アルゴリズム
            Judger.flagJudge(playerList);
//            強制終了の判断
            if(Option.forceEnd(playerList) == -1){
                break;
            }
//            表示
            if(i == 0) {
                System.out.print(" 0:|");
                for (j = 0; j < peopleNum; j++) {
                    System.out.print("出す手,");
                }
                System.out.print("|");
                for (j = 0; j < peopleNum; j++) {
                    System.out.print("点");
                }
                System.out.print("|");
                for (j = 0; j < peopleNum; j++) {
                    System.out.print("  連数");
                }
                System.out.print("|\n");
            }
            showSituation2(playerList, i);
        }
    }

    //    判定の表示
    private static void showSituation2(List<Player0> playerList, int presentTime) {
        int i;
        int peopleNum = playerList.size();
        String[] handsChanged;

//        手を日本語に変換
        handsChanged = changeHand(playerList, peopleNum);

        System.out.printf("%2d:|", presentTime + 1);
        for (i = 0; i < peopleNum; i++) {
            System.out.printf("%s,", handsChanged[i]);
        }
        System.out.print("|");
        for (i = 0; i < peopleNum; i++) {
            System.out.printf("%d,", playerList.get(i).getWinNum());
        }
        System.out.print("|");
        for (i = 0; i < peopleNum; i++) {
            System.out.printf("%4d,", playerList.get(i).getConsecutiveNum());
        }
        System.out.print("|\n");
    }

    //    手を日本語に変換するメソッド
    private static String[] changeHand(List<Player0> playerList, int peopleNum) {
        int i;
        String[] handsChanged = new String[peopleNum];

        for (i = 0; i < peopleNum; i++) {
            switch (playerList.get(i).getHand()) {
                case 0:
                    handsChanged[i] = "グー　";
                    break;
                case 1:
                    handsChanged[i] = "チョキ";
                    break;
                case 2:
                    handsChanged[i] = "パー　";
                    break;
            }
        }
        return handsChanged;
    }

    //    最終状態の表示
    static void finalJudged2(List<Player0> player0List) {
        Collections.sort(player0List, new MyComp());

        int i;
        int peopleNum = player0List.size();
        System.out.print("------------------------------------------\n");
        System.out.print("------------------------------------------\n");
        System.out.println("順位（勝ち数）");
        System.out.print("------------------------------------------\n");
        for (i = 0; i < peopleNum; i++) {
            System.out.printf("%d | %s (%d)\n",i+1, player0List.get(i).getName(),player0List.get(i).getWinNum());
        }
    }
}
