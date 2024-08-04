class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    List<TreeNode> helper(int start, int end){
        
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){

            List<TreeNode> leftBST = helper(start, i - 1);
            List<TreeNode> rightBST = helper(i + 1, end);
            
            for(TreeNode left : leftBST) {
                for(TreeNode right : rightBST){
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        return res;
    }
}