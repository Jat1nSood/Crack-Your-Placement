class Solution
{
    
    static boolean isLeaf(Node root){
        
        return root.left == null && root.right == null;
    }
    static boolean helper(Node root, int lowerBound, int upperBound){
        
        if(root == null) return false;
        if(isLeaf(root)){
            if(lowerBound + 1 == root.data  && upperBound - 1 == root.data)
                return true;
            else return false;
        }
        
        if(helper(root.left, lowerBound, root.data)) return true;
        if(helper(root.right, root.data, upperBound)) return true;
        return false;
    }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return helper(root.left, 0, root.data) || helper(root.right, root.data, Integer.MAX_VALUE);
        
    }
}