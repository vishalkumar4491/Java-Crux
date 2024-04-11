package O8_RecursionPrint;

public class O1_PrintSubsequence {
    public static void main(String[] args) {
        printSubs("abc", "");
    }

    public static void printSubs(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char c = str.charAt(0);
        String subS = str.substring(1);
        printSubs(subS, ans);
        printSubs(subS, ans + c);
        
    }
}
