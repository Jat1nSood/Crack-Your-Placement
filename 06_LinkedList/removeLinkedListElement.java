class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) return head;
        while( head != null && head.val == val) head = head.next;

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){

            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            } else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}