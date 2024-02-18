package O1_Basics;

import java.util.Scanner;

public class O6_SumOfNNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int ans = 0;
        while(i <= n){
            ans += i;
            i += 1;
        }
        System.out.println(ans);
    }
}
