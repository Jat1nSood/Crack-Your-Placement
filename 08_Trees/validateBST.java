class Solution {

    boolean check(TreeNode root, long lowerBound, long upperBound){
        if(root == null) return true;

        if(root.val <= lowerBound || root.val >= upperBound) return false;

        return check(root.left, lowerBound, root.val) && check(root.right, root.val, upperBound);
    }
    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;
        return check(root.left, Long.MIN_VALUE, root.val) && check(root.right, root.val, Long.MAX_VALUE);
        
    }
}