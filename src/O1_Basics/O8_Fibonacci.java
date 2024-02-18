package O1_Basics;

import java.util.Scanner;

public class O8_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = 0, n2 = 1;
        int i = 1;
        while(i <= n){
            System.out.println(n2);
            int x = n1;
            n1 = n2;
            n2 += x;
            i += 1;
        }
    }
}
