class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1 == null) return root2;
        if(root2 == null) return root1;
    
        int sum = root1.val  + root2.val;
        TreeNode root = new TreeNode(sum);
        
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}