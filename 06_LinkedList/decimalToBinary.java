class Solution {
    public int getDecimalValue(ListNode head) {
        
        ListNode curr = head;
        int ans = 0;

        while(curr != null){
            ans = ans * 2;
            ans += curr.val;
            curr = curr.next;
        }
        return ans;
    }
}