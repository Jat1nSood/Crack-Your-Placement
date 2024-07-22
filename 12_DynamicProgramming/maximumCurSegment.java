class Solution
{
    //Function to find the maximum number of cuts.
    int helper(int n, int x, int y, int z, int[] dp){
        
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int withX = Integer.MIN_VALUE;
        int withY = Integer.MIN_VALUE;
        int withZ = Integer.MIN_VALUE;
        
        if(x <= n){
            
            withX = 1 + helper(n - x, x, y, z, dp);
        }
        if(y <= n){
            withY = 1 + helper(n - y, x, y, z, dp);
        }
        if(z <= n){
            withZ = 1 + helper(n - z, x, y, z, dp);
        }
        dp[n] = Math.max(withX, Math.max(withY, withZ));
        return dp[n];
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[] = new int[n + 1];
       Arrays.fill(dp, -1);
       int result = helper(n, x, y, z, dp);
       return result < 0 ? 0 : result;
       
    }
}
