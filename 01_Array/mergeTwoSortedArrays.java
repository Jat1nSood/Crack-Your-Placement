class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {

        int i = n - 1;
        int j = m - 1;
        int k = m + n -1;

        while(j >= 0){

            if(i >= 0 && nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            } else{

                nums1[k--] = nums2[j--]; 
            }

        }
    }
}