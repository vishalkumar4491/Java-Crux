package O8_RecursionPrint;

public class O6_CountMazePath {
    public static void main(String[] args) {
        System.out.println(countMazePath(0, 0, 2, 2));
    }

    public static int countMazePath(int cr, int cc, int n, int m){
        if(cr == n && cc == m){
            return 1;
        }
        if(cr > n || cc > m) return 0;
        int ans = 0;
        ans += countMazePath(cr + 1, cc, n, m);
        ans += countMazePath(cr, cc + 1, n, m);
        return ans;
    }
}
