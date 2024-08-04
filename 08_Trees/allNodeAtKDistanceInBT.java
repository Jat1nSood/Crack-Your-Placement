class Solution {

    void inorder(TreeNode root, Map<TreeNode, TreeNode> parent){

        if(root == null) return;

        if(root.left != null) parent.put(root.left, root);
        inorder(root.left, parent);

        if(root.right != null) parent.put(root.right, root);
        inorder(root.right, parent);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        inorder(root, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();

        q.offer(target);
        vis.add(target);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            
            if(level == k) break;
            while(n != 0){

                TreeNode front = q.poll();
               
                    if(front.left != null && !vis.contains(front.left)){
                        q.offer(front.left);
                        vis.add(front.left);
                    }
                    if(front.right != null && !vis.contains(front.right)) {
                        q.offer(front.right);
                        vis.add(front.right);
                    }
                    
                    if(parent.get(front) != null && !vis.contains(parent.get(front))){
                        q.add(parent.get(front));
                        vis.add(parent.get(front));
                    } 
                
                n--;
            }
            level++;
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}