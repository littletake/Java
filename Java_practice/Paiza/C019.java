import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //これが判断する数字の数
        ArrayList<Integer> list;
        for(int i = 0 ; i < n ; i++){
            int m = sc.nextInt();
            int div;
            div = makeDivisor(m); //ここで約数の生成
            classfyNum(m, div);
        }
    }

    public static int makeDivisor(int num){
        int i;
        int divisor = 0;
        for(i=0;i<num;i++){
            if((i != 0) && (num % i == 0)){
                divisor += i;
            }
        }
        return divisor;
    }

    public static void classfyNum(int num, int div){
        int abs_num = Math.abs(num - div);
        if(abs_num == 0){
            System.out.println("perfect");
        } else if(abs_num == 1) {
            System.out.println("nearly");
        } else {
            System.out.println("neither");
        }
    }


}
