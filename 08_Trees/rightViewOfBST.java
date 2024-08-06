package 08_Trees;

public class rightViewOfBST {
    
}
class Solution {

    void helper(TreeNode root, int level, List<Integer> ans){

        if(root == null) return;

        if(level == ans.size()) ans.add(root.val);
        helper(root.right, level + 1, ans);
        helper(root.left, level + 1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        helper(root, 0, ans);
        return ans;
    }
}