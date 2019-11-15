import java.util.List;

class OnlyGuPlayer extends Player0{
    OnlyGuPlayer(){
        super();
    }

    @Override
    void jankenMethod(int i, List<Player0> playerList) {
        int value = 0;
        setHand(value);

    }
}
