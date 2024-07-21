class Solution {
    private boolean check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;
        return (check(root.left, subRoot.left) && check(root.right, subRoot.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null) return false;
        if(root.val == subRoot.val){
            if(check(root, subRoot)) return true;
        }

        if(isSubtree(root.left, subRoot)) return true;
        if(isSubtree(root.right, subRoot)) return true;
        return false;
    }
}