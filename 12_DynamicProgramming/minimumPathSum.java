class Solution {

    public int helper(int row, int col, int[][] grid, int[][] dp){

        if(row == 0 && col == 0) return grid[0][0];
        if(dp[row][col] != -1) return dp[row][col];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(row - 1 >= 0){
            up = grid[row][col] + helper(row - 1, col, grid, dp);
        }
        if(col - 1 >= 0)
            left = grid[row][col] + helper(row, col - 1, grid, dp);

        return dp[row][col] = Math.min(up, left); 
    }
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(n-1, m-1, grid, dp);
    }
}