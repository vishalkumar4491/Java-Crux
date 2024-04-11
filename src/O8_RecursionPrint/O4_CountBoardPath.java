package O8_RecursionPrint;

public class O4_CountBoardPath {
    public static void main(String[] args) {
        System.out.println(countBoardPath(0, 10));
    }

    public static int countBoardPath(int curr, int n){
        if(curr == n){
            return 1;
        }
        if(curr > n){
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= 6; i++){
             count += countBoardPath(curr + i, n);
        }
        return count;
    }
}
