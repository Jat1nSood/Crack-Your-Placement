class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        
        if(h1 == null && h2 == null) return h1;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(h1 != null && h2 != null){

            if(h1.val <= h2.val){
                tail.next = h1;
                h1 = h1.next;
                tail = tail.next;
            } else{
                tail.next = h2;
                h2 = h2.next;
                tail = tail.next;
            }
        }

        tail.next = h1 == null ? h2 : h1;
        return dummy.next;
    }
}