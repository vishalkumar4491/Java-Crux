package O1_Basics;

import java.util.Scanner;

public class O4_OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 2 == 0){
            System.out.println(n + " is an even number");
        }else{
            System.out.println(n + " is an odd number");
        }
    }
}
