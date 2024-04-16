package O10_Backtracking;

public class O2_1DQueenCombination {
    public static void main(String[] args) {
        boolean[] board = new boolean[4];
        queenCombination(board, 0, 2, "", 0);
    }

    static int count = 1;
    public static void queenCombination(boolean[] board, int qps, int tq, String ans, int lastBoxUsed){
        if(qps == tq){
            System.out.println(count + " " + ans);
            count += 1;
            return;
        }
        for(int i = lastBoxUsed; i < board.length; i++){
            if(board[i] == false){
                board[i] = true;
                queenCombination(board, qps + 1, tq, ans + "q" + qps + "b" + i + " ", i + 1);
                board[i] = false;
            }
        }
    }
}
