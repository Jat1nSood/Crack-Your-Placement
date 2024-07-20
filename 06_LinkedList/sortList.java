class Solution {
    public ListNode sortList(ListNode head) {
        

        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode high = mid.next;
        mid.next = null;
        
        ListNode h1 = mergeSort(head);
        ListNode h2 = mergeSort(high);
        return merge(h1, h2);
    }

    public ListNode merge(ListNode h1, ListNode h2){

        ListNode dummy = new ListNode(0);
        ListNode tail  = dummy;

        while(h1 != null && h2 != null){

            if(h1.val <= h2.val){
                tail.next = h1;
                tail = tail.next;
                h1 = h1.next;
            } else{
                tail.next = h2;
                tail = tail.next;
                h2 = h2.next;
            }
        }
        if(h1 != null){
            tail.next = h1;
        }
        if(h2 != null){
            tail.next = h2;
        }
        return dummy.next;
    }

    public ListNode findMid(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}