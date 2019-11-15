import java.util.List;

class OnlyTyokiPlayer extends Player0{
    OnlyTyokiPlayer(){
        super();
    }

    @Override
    void jankenMethod(int i, List<Player0> playerList) {
        int value = 1;
        setHand(value);
    }
}
