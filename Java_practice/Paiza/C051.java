import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list_1 = new ArrayList<>();
        //List<Integer> list_2 = new ArrayList<>();
        int num, a, b, c;

        for(int i = 0; i < 4; i++){
            num = sc.nextInt();
            list_1.add(num);
        } //これでlist_1は完成

        sortNum(list_1); //sort
        a = list_1.get(0) * 10 + list_1.get(2);
        b = list_1.get(1) * 10 + list_1.get(3);
        c = a + b;

        System.out.println(c);


    }

    public static void sortNum(List<Integer> list_1){
        int tmp;
        for(;;){
            for(int i = 0; i < 3; i++){
                if(list_1.get(i) < list_1.get(i+1)){
                    tmp = list_1.get(i);
                    list_1.set(i, list_1.get(i+1));
                    list_1.set(i + 1, tmp);
                }
            }
            if(list_1.get(0) >= list_1.get(1) && list_1.get(1) >= list_1.get(2) && list_1.get(2) >= list_1.get(3)){
                break;
            }
        }
    }
}
