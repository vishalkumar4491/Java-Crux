package O7_RecursionGet;
import java.util.ArrayList;

public class O2_Permutation {
    public static void main(String[] args) {
        ArrayList<String> list = getPermutation("abcd");
        for(int i = 0; i < list.size(); i++){
            System.out.println(i  + "  " + list.get(i));
        }
    }

    public static ArrayList<String> getPermutation(String str){
        if(str.length() == 0){
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        Character currChar = str.charAt(0);
        String subStr = str.substring(1);
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> subAns = getPermutation(subStr);
        for(int i = 0; i < subAns.size(); i++){
            for(int j = 0; j <= subAns.get(i).length(); j++){
                String sp = subAns.get(i).substring(0, j);
                String ep = subAns.get(i).substring(j);
                String s = sp + currChar + ep;
                ans.add(s);
            }
        }
        return ans;
    }
}
