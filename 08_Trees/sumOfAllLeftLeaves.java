class Solution {

    boolean isLeaf(TreeNode root){

        return root.left == null && root.right == null;
    }
    void helper(TreeNode root, int[] sum){

        if(root == null) return;
        helper(root.left, sum);
        helper(root.right, sum);

        if(root.left != null && isLeaf(root.left))
            sum[0] += root.left.val;
    }
    public int sumOfLeftLeaves(TreeNode root) {

        int sum[] = {0};
        helper(root, sum);
        return sum[0];
    }
}