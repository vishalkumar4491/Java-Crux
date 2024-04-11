package O8_RecursionPrint;

public class O2_PrintPermuation {
    public static void main(String[] args) {
        printPermuation("abc", "");
    }

    public static void printPermuation(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String subStr = str.substring(0, i) + str.substring(i + 1);
            printPermuation(subStr, ans + ch);
        }
    }
}
