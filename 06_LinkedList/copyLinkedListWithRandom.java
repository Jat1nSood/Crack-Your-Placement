class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;

        

        while(curr != null){

            Node next = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        curr = head;
        while(curr != null && curr.next != null){

            if(curr.random == null){
                curr.next.random = null;
            }
            else{
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        Node tail = newHead;
        while(curr != null && tail != null){
            curr.next = curr.next == null ? null :  curr.next.next;
            tail.next = tail.next == null ? null :  tail.next.next;

            tail = tail.next;
            curr = curr.next;
    
        }
        return newHead;
    }
}