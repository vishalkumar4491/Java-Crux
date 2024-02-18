package O1_Basics;

import java.util.Scanner;

public class O9_GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        
        while(n1 % n2 != 0){
            int x = n1;
            n1 = n2;
            n2 = x % n2;
        }
        System.out.println(n2);
    }
}
