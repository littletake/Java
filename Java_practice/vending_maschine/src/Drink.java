//商品のデータベース(特に値段)
public class Drink {
    private int drinkPrice[] = new int[3];

    public Drink() {
        drinkPrice[0] = 100;
        drinkPrice[1] = 200;
        drinkPrice[2] = 300;
    }

    public int getDrinkPrice(int num){
        return drinkPrice[num];
    }
}
