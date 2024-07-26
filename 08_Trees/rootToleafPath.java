class Solution {

    void helper(TreeNode root, List<String> ans, StringBuilder sb){

        if(root == null) return;
        
        int len = sb.length();
        sb.append(root.val);
        

        if(root.left == null && root.right == null){
              ans.add(sb.toString());
        } else{
            sb.append("->");
            helper(root.left, ans, sb);
            helper(root.right, ans, sb);
        }

        sb.setLength(len);
        
        
        
    }
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        StringBuilder sb = new StringBuilder();
    
        helper(root, ans, sb);
        return ans;
        
    }
}