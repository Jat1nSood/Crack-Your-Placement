class Solution {

    boolean helper(TreeNode root, int sum){

        if(root == null) return false;

        if(root.left == null && root.right == null){

            if(sum - root.val == 0) return true;
            return false;
        }
        
        if(helper(root.left, sum - root.val)) return true;
        if(helper(root.right, sum - root.val)) return true;
        
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
     
        

        return helper(root, targetSum);

        
    }
}