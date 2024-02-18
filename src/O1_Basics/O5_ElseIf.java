package O1_Basics;

import java.util.Scanner;

public class O5_ElseIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n <= 11){
            System.out.println("Child");
        }else if(n >= 12 && n < 18){
            System.out.println("Teenager");
        }else if(n >= 18 && n <= 60){
            System.out.println("Adult");
        }else{
            System.out.println("Old");
        }
    }
}
