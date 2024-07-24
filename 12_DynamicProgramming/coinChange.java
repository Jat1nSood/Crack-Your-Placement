class Solution {

    private int findMinNumberOfCoins(int index, int[] coins, int amount, int[][] memo){

        if(index == 0){
            if( amount % coins[index] == 0) return amount / coins[index];
            return Integer.MAX_VALUE;
        }
        if(memo[index][amount] != -1) return memo[index][amount];
        int notTake = 0 + findMinNumberOfCoins(index - 1, coins, amount, memo);
        int take = Integer.MAX_VALUE;
    
        if (coins[index] <= amount) {
            int res = findMinNumberOfCoins(index, coins, amount - coins[index], memo);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        return memo[index][amount] =  Math.min(take, notTake);

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(memo[i], -1);
        }
        int result = findMinNumberOfCoins(n - 1, coins, amount, memo);
        if(result == Integer.MAX_VALUE) return -1;
        return result;
    }
}







