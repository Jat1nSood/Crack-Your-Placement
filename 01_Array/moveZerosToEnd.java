class Solution {
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {

        int zeroPos = -1;
        int n = nums.length;

        for(int i = 0; i < n; i++){

            if(nums[i] == 0) {
                zeroPos = i;
                break;
            }
        }
        if(zeroPos == -1) return;
        for(int i = zeroPos + 1; i < n; i++){
            if(nums[i] != 0){
                swap(i, zeroPos, nums);
                zeroPos++;
            }
        }
        return;
    }
}