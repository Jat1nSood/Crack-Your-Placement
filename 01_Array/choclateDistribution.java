class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        int minDiff = Integer.MAX_VALUE;
        if(m > n) return -1;
        Collections.sort(a);
        
        int left = 0;
        int right = m - 1;
        
        while(right < n){
            
            minDiff = Math.min(minDiff, a.get(right) - a.get(left));
            left++;
            right++;
        }
        return minDiff;
    }
}