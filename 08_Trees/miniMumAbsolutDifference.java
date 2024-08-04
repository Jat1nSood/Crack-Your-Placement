class Solution {

    void helper(TreeNode root, int[] min, TreeNode[] prev){

        if(root == null) return;

        

        helper(root.left, min, prev);
        if(prev[0] != null){
            min[0] = Math.min(min[0], Math.abs((root.val - prev[0].val)));
        }
        prev[0] = root;
        helper(root.right, min, prev);
    }
    public int getMinimumDifference(TreeNode root) {
        
        int []min = {Integer.MAX_VALUE};
        TreeNode []prev = {null};
        helper(root, min, prev);
        return min[0];

    }
}