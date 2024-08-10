import java.util.ArrayList;

public class Solution {

    public static int[] maxValue(int n, int k, int m, int[][] a){

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(i == 0) dp[i][j] = a[i][j];
                else if(j == 0) dp[i][j] = Math.max(a[i][j], dp[i-1][j]);
                
                else dp[i][j] = Math.max(a[i][j], Math.max(dp[i][j-1], dp[i-1][j]));
            }
        }
        ArrayList<Integer> p = new ArrayList<>();
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(i + k - 1  > n - 1) continue;
                if(j + k - 1 > n - 1) continue;

                int maxOfSub = Math.max(Math.max(dp[i][j], dp[i + k-1][j + k-1]), Math.max(dp[i][j+ k-1], dp[i+ k-1][j]));
                p.add(maxOfSub);
            }
        }
        
        int count = 0;
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        for(int val : p){
            
            if(val >= m){
                count++;
                if(val > maxElement) maxElement = val;
                if(val < minElement) minElement = val;
            }
        }

        return new int[]{count, minElement, maxElement};

    }

    public static void main(String[] args){

        int[][] a = {
            {4, 6, 7, 3, 10, 2},
            {3, 8, 1, 2, 4, 7} ,
            {1, 7, 3, 7, 2, 9},
            {8, 9, 3, 1, 3, 4},
            {8, 6,5, 3, 4, 9},
            {10, 8, 4, 7,2, 3}
        };
        int[] res = maxValue(6, 4, 5, a);

        for(int val : res){
            System.out.println(val);
        }
    }
    
}



//hello