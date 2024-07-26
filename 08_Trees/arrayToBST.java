class Solution {

    TreeNode helper(int start, int end, int[] nums){

        if(start > end) return null;
        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid - 1, nums);
        root.right = helper(mid +1, end, nums);
        return root;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(0, n - 1, nums);
    }
}