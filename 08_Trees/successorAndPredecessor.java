class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        
        
        findP(root, key, pre);
        findS(root, key, suc);
        
    }
    
    static void findP(Node root, int key, Node[] pre){
        
        if(root == null) return;
        
        if(root.data < key){
            
            if(pre[0] != null){
                if(root.data > pre[0].data){
                    pre[0] = root;
                }
            }
            else{
                pre[0] = root;
            }
            findP(root.right, key, pre);
        }
        findP(root.left, key, pre);
    }
    
    static void findS(Node root, int key, Node[] suc){
        
        if(root == null) return;
        
        if(root.data > key){
            
            if(suc[0] != null){
                if(root.data < suc[0].data)
                    suc[0] = root;
            }
            else{
                suc[0] = root;
            }
            findS(root.left, key, suc);
        }
        findS(root.right, key, suc);
    }
}


