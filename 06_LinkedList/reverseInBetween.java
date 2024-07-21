class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right) return head;
        ListNode curr = head;
        ListNode prev = null;
        int index = 1;
        while(curr != null){

            if(index == left){
                if(left == 1) head = reverse(curr, right, index);
                else prev.next = reverse(curr, right, index); 
                break;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        return head;
    }

    private ListNode reverse(ListNode head, int right, int index){

        ListNode curr = head;
        ListNode prev = null;
        while(index <= right){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;
        }
        head.next = curr;
        return prev;
    }
}