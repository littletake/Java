//randomで手を出すメソッド
public class RandomMethod {

    public static int jankenMethod(){
        int hand;
        hand = (int)(Math.random() * 10);
        hand = hand % 3;
        return hand;
    }
}
