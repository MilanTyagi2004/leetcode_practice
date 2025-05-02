class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // Step 1: Create new nodes and insert them after the original nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }
        
        // Step 2: Copy the random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        // Step 3: Separate the two lists
        Node newHead = head.next;
        current = head;
        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            current = current.next;
        }
        
        return newHead;
    }
}
