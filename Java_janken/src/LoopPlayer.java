//0, 1, 2と順に手を出す
//継承を使ってみた

import java.util.List;

/*package-private*/
class LoopPlayer extends Player0{
    LoopPlayer(){
        super();
    }

    void jankenMethod(int i, List<Player0> playerList){
        int value;
        value = i % 3;
        setHand(value);
    }
}
