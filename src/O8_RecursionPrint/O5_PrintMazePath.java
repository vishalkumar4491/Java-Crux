package O8_RecursionPrint;

public class O5_PrintMazePath {
    public static void main(String[] args) {
        printMazePath(0, 0, 2, 2, "");
    }

    public static void printMazePath(int cr, int cc, int n, int m, String ans){
        if(cr == n && cc == m){
            System.out.println(ans);
            return;
        }
        if(cr > n || cc > m){
            return;
        }
        printMazePath(cr + 1, cc, n, m, "V" + ans);
        printMazePath(cr, cc + 1, n, m, "H" + ans);
    }
}
