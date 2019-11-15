//sort用のクラス

import java.util.Comparator;

public class MyComp implements Comparator<Player0> {
    public int compare(Player0 p1, Player0 p2) {
        if(p1.getWinNum() < p2.getWinNum()) {
            return 1;
        } else if (p1.getWinNum() == p2.getWinNum()){
            return 0;
        } else {
            return -1;
        }
    }
}
