package O7_RecursionGet;
import java.util.ArrayList;

public class O3_GetBoardPath {
    public static void main(String[] args) {
        System.out.println(getPaths(10).size());
    }

    public static ArrayList<String> getPaths(int n){
        if(n < 0){
            return new ArrayList<String>();
        }
        if(n == 0){
            ArrayList<String> bc =  new ArrayList<String>();
            bc.add("");
            return bc;
        }
        ArrayList<String> myAns = new ArrayList<String>();
        for(int i = 1; i <= 6; i++){
            ArrayList<String> subAns = getPaths(n - i);
            for(int j = 0; j < subAns.size(); j++){
                myAns.add(i + subAns.get(j));
            }
        }
        return myAns;
    }
}
