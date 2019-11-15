//0: グー, 1: チョキ, 2: パー
//アブストラクト（抽象化）を使うことでより楽なコードになる。

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player0> playerList = new ArrayList<>();

//      参加者の人数を決める。
        Option.decidePlayer(playerList);

//      じゃんけんの回数は20000回
        int runtime = 20000;

        BattleField.mainJudge(playerList, runtime);
        BattleField.finalJudged2(playerList);
    }
}
