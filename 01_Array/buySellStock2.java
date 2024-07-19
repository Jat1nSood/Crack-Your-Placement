class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int totalProfit = 0;
        for(int i = 1; i < n; i++){

            int profit = prices[i] - prices[i-1];
            if(profit > 0) totalProfit += profit;
        }
        return totalProfit;
    }
}