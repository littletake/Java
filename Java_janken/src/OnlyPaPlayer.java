import java.util.List;

public class OnlyPaPlayer extends Player0{
    OnlyPaPlayer(){
        super();
    }

    @Override
    void jankenMethod(int i, List<Player0> playerList) {
        int value = 2;
        setHand(value);
    }
}