import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Machine machine = new Machine();
        Client player = new Client();
        Drink drinkData = new Drink();

        machine.Order(player);
        machine.Pay(player, drinkData);

    }
}
