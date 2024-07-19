class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if(n == 1 || n == 0) return 0;

        int left = 0;
        int right = n - 1;
        int result = 0;

        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(area, result);
            if(height[left] < height[right]) left++;
            else right--; 
        }
        return result;
    }
}