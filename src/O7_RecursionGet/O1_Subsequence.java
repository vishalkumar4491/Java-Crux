package O7_RecursionGet;
import java.util.ArrayList;

public class O1_Subsequence {
    public static void main(String[] args) {
        ArrayList<String> list = getSubsequence("abcd");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static ArrayList<String> getSubsequence(String str){
        if(str.length() == 0){
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        Character currentChhar = str.charAt(0);
        String subStr = str.substring(1);
        ArrayList<String> myResult = new ArrayList<>();
        ArrayList<String> result = getSubsequence(subStr);

        for(int i = 0; i < result.size(); i++){
            myResult.add(result.get(i));
            myResult.add(currentChhar + result.get(i));
        }
        return myResult;

    }
}
