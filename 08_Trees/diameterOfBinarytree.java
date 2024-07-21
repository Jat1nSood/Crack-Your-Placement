class Solution {

    int helper(TreeNode root, int[] diameter){

        if(root == null) return 0;

        int left = helper(root.left, diameter);
        int right = helper(root.right, diameter);

        diameter[0] = Math.max(left + right, diameter[0]); 
        return 1 + Math.max(left, right);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int[]diameter = {0};
        helper(root, diameter);
        return diameter[0];
    }
}