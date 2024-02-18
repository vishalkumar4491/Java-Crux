package O1_Basics;

import java.util.Scanner;

public class O2_SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float P = sc.nextFloat();
        float R = sc.nextFloat();
        float T = sc.nextFloat();

        float SI = P * R * T / 100;
        System.out.println(SI);
    }
}
