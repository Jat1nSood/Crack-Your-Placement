class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        int MOD = (int) 1e9 + 7;
        Node curr = first;
        long s1 = 0;
        while(curr != null){
            
            s1 = ((s1*10)%MOD + curr.data) % MOD;
            curr = curr.next;
        }
        long s2 = 0;
        curr = second;
        while(curr != null){
            s2 =( s2 * 10) % MOD  + curr.data;
            curr  = curr.next;
        }
        
        return (s1 * s2) % MOD;
    }
}