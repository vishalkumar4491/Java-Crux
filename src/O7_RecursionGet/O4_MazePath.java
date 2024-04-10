package O7_RecursionGet;

import java.util.ArrayList;

public class O4_MazePath {
    public static void main(String[] args) {
        System.out.println(getMazePath(0, 0, 2, 2));
    }

    public static ArrayList<String> getMazePath(int cr, int cc, int n, int m){
        if(cr == n && cc == m){
            ArrayList<String> bc = new ArrayList<>();
            bc.add("");
            return bc;
        }
        if(cr > n || cc > m){
            return new ArrayList<String>();
        }
        ArrayList<String> myAns = new ArrayList<String>();
        ArrayList<String> hAns = getMazePath(cr, cc + 1, n, m);
        for(String hA: hAns){
            myAns.add("H" + hA);
        }
        ArrayList<String> vAns = getMazePath(cr + 1, cc, n, m);
        for(String vA: vAns){
            myAns.add("V" + vA);
        }
        ArrayList<String> dAns = getMazePath(cr + 1, cc + 1, n, m);
        for(String dA: dAns){
            myAns.add("D" + dA);
        }
        return myAns;
    }
}
