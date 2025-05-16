class Solution {
    public ListNode swapPairs(ListNode head) {
        // Base case: if the list has less than 2 nodes, no swap is needed
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node to handle the edge case when the head is swapped
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize the previous node as the dummy node
        ListNode prev = dummy;

        // Traverse the list in pairs
        while (head != null && head.next != null) {
            // Assign the first and second nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // Perform the swap
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move the pointers for the next pair
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
