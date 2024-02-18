package O1_Basics;

import java.util.Scanner;

public class O7_IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        while(i < n){
            if(n % 2 == 0){
                System.out.println("Not Prime");
                break;
            }
            i += 1;
        }

        if(i == n){
            System.out.println("Prime");
        }
    }
}
