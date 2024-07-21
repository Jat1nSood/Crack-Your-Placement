class Solution {

    private void helper(TreeNode root, int low, int high, int[] sum){

        if(root == null) return;

        if(low <= root.val && root.val <= high) sum[0] += root.val;
        helper(root.left, low, high, sum);
        helper(root.right, low, high, sum);

        }
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        int[] sum = {0};
        helper(root, low, high, sum);
        return sum[0];
    }
}