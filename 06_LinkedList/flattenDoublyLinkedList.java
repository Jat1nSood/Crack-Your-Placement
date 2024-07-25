
class Solution {

    Node helper(Node head){

        Node curr = head;
        while(curr.next != null || curr.child != null){
            if(curr.child != null){

                Node next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = helper(curr);
                curr.next = next;
                if(next == null) continue;
                next.prev = curr;
                curr = curr.next;
            }
            else curr = curr.next;
        }
        return curr;
    }
    public Node flatten(Node head) {
        if(head == null) return head;

        helper(head);
        return head;
    }
}