package O1_Basics;

public class O11_ForLoop {
    public static void main(String[] args) {       
        for(int i = 1; i < 10; i++){
            System.out.println(i);
        }

        System.out.println("----------------");

        // Same thing can be written as
        int counter = 1;
        for(;counter < 10; counter++){
            System.out.println(counter);
        }

        System.out.println("----------------");


        //same thing can be written as
        int i = 1;
        for(;i < 10;){
            System.out.println(i);
            i++;
        }
    }
}
