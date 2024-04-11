package O8_RecursionPrint;

public class O7_CountNQueen {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        System.out.println(countNQueens(board, 0, 4));
    }

    public static int countNQueens(int[][] board, int cr, int n) {
        if(cr == n) return 1;

        int ans = 0;
        for(int col = 0; col < n ;col++){

            if(isValid(board, cr, col)){
                board[cr][col] = 1;
                ans += countNQueens(board, cr + 1, n);
                board[cr][col] = 0;
            }
        }
        return ans;
        
    }

    public static boolean isValid(int[][] board, int cr, int cc) {
        for(int i = 0; i < cr; i++){
            if(board[i][cc] == 1) return false;
        }
        for(int i = 0; i < cc; i++){
            if(board[cr][i] == 1) return false;
        }
        int r = cr - 1, c = cc - 1;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 1) return false;
            r--;
            c--;
        }
        r = cr - 1;
        c = cc + 1;
        while(r >= 0 && c < board.length){
            if(board[r][c] == 1) return false;
            r--;
            c++;
        }
        r = cr + 1;
        c = cc - 1;
        while(r < board.length && c >= 0){
            if(board[r][c] == 1) return false;
            r++;
            c--;
        }
        r = cr + 1;
        c = cc + 1;
        while(r < board.length && c < board.length){
            if(board[r][c] == 1) return false;
            r++;
            c++;
        }
        return true;
    }
}
