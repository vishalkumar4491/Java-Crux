package O8_RecursionPrint;

public class O3_PrintBoardPath {
    public static void main(String[] args) {
        printBoardPath(0, 10, "");
    }

    public static void printBoardPath(int curr, int n, String ans) {
        if(curr == n){
            System.out.println(ans);
            return;
        }
        if(curr > n){
            return;
        }
        for(int i = 1; i <= 6; i++){
            printBoardPath(curr + i, n, i + ans);
        }
    }
}
