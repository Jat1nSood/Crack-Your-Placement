class Solution {
    int MOD = (int) 1e9 + 7;
    private int solve(int n, int cell, int[][] adj, int[][] dp){

        if(n == 0) return 1;

        if(dp[n][cell] != -1) return dp[n][cell];
        int count = 0;

        for(int nextCell : adj[cell]){
            count = (count +  solve(n - 1, nextCell, adj, dp)) % MOD;
        }
        return dp[n][cell] =  count;
    }
    public int knightDialer(int n) {
        
        int[][] dp = new int[n + 1][10];
        int[][] adj = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1 ,0, 7}, {2, 6}, {1, 3}, {2, 4}};
        int total = 0;

        for(int i =0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i <= 9; i++){
            total = (total +  solve(n-1, i, adj, dp)) % MOD;
        }
        return total;
    }
}


