package O10_Backtracking;

public class O1_1DQueenPermutation {
    public static void main(String[] args) {
        boolean[] board = new boolean[4];
        queenPermuatation(board, 0, 2, "");
    }

    public static void queenPermuatation(boolean[] board, int qps, int tq, String ans){
        if(qps == tq){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(board[i] == false){
                board[i] = true;
                queenPermuatation(board, qps + 1, tq, ans + "q" + qps + "b" + i + " ");
                board[i] = false;
            }
        }
    }
}
