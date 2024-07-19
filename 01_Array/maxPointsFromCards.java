class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int leftSum = 0;
        int n = cardPoints.length;

        for(int i = 0; i < k; i++){
            leftSum += cardPoints[i];
        }
        int maxSum = leftSum;
        int rightSum = 0;
        int rightIndex = n - 1;

        for(int i = k - 1; i >= 0; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex--];
            int sum = leftSum + rightSum;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}