import java.util.Scanner;

public class Machine {
    private int colaStock;
    private int dietColaStock;
    private int teaStock;

    //コンストラクタ
    public Machine(){
        this.colaStock = 5;
        this.dietColaStock = 5;
        this.teaStock = 5;
    }

    public static void Order(Client player){
        int input1, input2;
        String order;
        Scanner scanner = new Scanner(System.in);

        for(;;) {
            System.out.println("-----------------------------");
            System.out.println("ORDER MENU");
            System.out.println("-----------------------------");
            System.out.println("Cola:0 || DietCola:1 || Tea:2");
            System.out.print("ほしい飲み物は何ですか？：");

            input1 = scanner.nextInt(); //これで入力が行われる。
            order = Machine.correctOrder(input1); //確認
            if(order.equals("not")){
                continue;
            } else {
                System.out.printf("ほしい飲み物：%s\n", order);
                System.out.printf("これで正しいですか？[no:0, yes:1]：");
                input2 = scanner.nextInt();
                if(input2 == 0){
                    System.out.println();
                    continue;
                } else {
                    player.setWantDrink(input1);
                    System.out.println("↓");
                    break;
                }
            }
        }
    }

    public static String correctOrder(int order){
        String kind;
        if(order == 0){
            kind = "Cola";
        } else if(order == 1){
            kind = "DietCola";
        } else if(order == 2){
            kind = "Tea";
        } else {
            System.out.print("この番号の飲み物はありません。\n\n");
            kind = "not";
        }
        return kind;
    }

    public static void Pay(Client player, Drink drink){
        Scanner scanner = new Scanner(System.in);
        int price = drink.getDrinkPrice(player.getWantDrink());
        int input; //入金金額

        System.out.println("-----------------------------");
        System.out.println("PAY MENU");
        System.out.println("-----------------------------");
        System.out.printf("料金は%d円です。\n", price);
        System.out.print("入金：");
        input = scanner.nextInt();
        Machine.calculateMoney(price, input);
        System.out.println("Thank you!!");
    }

    public static void calculateMoney(int payment, int money) {
        Scanner scanner = new Scanner(System.in);
        int charge = 0, input;
        charge = money - payment;
        for (; ; ) {
            if (charge >= 0) {
                System.out.printf("おつり：%d円\n", charge);
                break;
            } else {
                System.out.printf("%d円足りません!\n", charge * -1);
                System.out.println("追加入金：");
                input = scanner.nextInt();
                charge += input;
            }
        }
    }
}
