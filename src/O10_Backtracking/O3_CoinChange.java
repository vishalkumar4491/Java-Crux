package O10_Backtracking;

public class O3_CoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6, 10, 12};
        coinChange(coins, 0, 10, "", 0);
    }

    static int count = 1;
    public static void coinChange(int[] coins, int curr, int target, String ans, int currIndex){
        if(curr == target){
            System.out.println(count + " " + ans);
            count += 1;
            return;
        }
        if(curr > target) return;
        
        for(int i = currIndex; i < coins.length; i++){
            coinChange(coins, curr + coins[i], target, ans + coins[i], i);
        }
    }
}
