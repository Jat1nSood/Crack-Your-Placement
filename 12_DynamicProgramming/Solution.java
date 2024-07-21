class Solution {

    int helper(int ind, String[] strs, int m, int n, int[][][] dp){
       
        if(ind < 0) return 0;
        
        if(dp[ind][m][n] != -1) return dp[ind][m][n];
        String str = strs[ind];
        int zero = 0;
        int one = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '0') zero++;
            if(ch == '1') one++;
        }
        int take = 0;
        if(zero <= m && one <= n){
            
             take = 1 + helper(ind - 1, strs, m - zero, n - one, dp);
        }
        int notTake = 0 +  helper(ind - 1, strs, m, n, dp);
        
        dp[ind][m][n] =  Math.max(take, notTake);
        return dp[ind][m][n];
    }
    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int [strs.length + 1][m + 1][n + 1];
        for(int i = 0; i <= strs.length; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    dp[i][j][k] =-1;
                }
            }
        }
        return helper(strs.length - 1, strs, m, n, dp);
        
    }
}