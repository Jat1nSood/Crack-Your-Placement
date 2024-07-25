class Solution {
    public void reorderList(ListNode head) {
        
        
        ListNode mid = findMid(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;

        
        ListNode head1 = head.next;
        ListNode tail = head;

        while(head2 != null){
            
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;

            if(head1 != null){
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            }
        }
        
    }

    ListNode findMid(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}