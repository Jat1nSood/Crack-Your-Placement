class Solution {
    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode partition = null;
        ListNode partitionPrev = null;
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        

        while(curr != null){
            if(partition == null && curr.val >= x){
                partition = curr;
                partitionPrev = prev; 
            }
            if(partition != null && curr.val < x){    
                tail.next = curr;
                prev.next = curr.next;
                tail = tail.next;
                tail.next = partition;
            }
            prev = curr;
            curr = curr.next;
        }
        if(dummy.next == null) return head;

        if(partitionPrev == null){
            head = dummy.next;
        }
        else{
            partitionPrev.next = dummy.next;
        }
        return head;
    }
}