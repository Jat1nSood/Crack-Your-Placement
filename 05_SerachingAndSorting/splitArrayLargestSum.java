class Solution {
    boolean helper(int minSum, int[] nums, int k){

        int splits = 1;
        int n = nums.length;
        int currSum = 0;
        for(int i =0; i < n; i++){
            if(currSum + nums[i] > minSum){
                currSum = 0;
                splits++;
            }

            currSum += nums[i];
        }
        return splits <= k;
    }
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;
        int sum = 0;
        int max = -1;
        for(int i =0; i < n; i++){
            sum += nums[i];
            max = Math.max(nums[i], max);
        }

        int left = max;
        int right = sum;
        int ans = -1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(helper(mid, nums, k)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
}