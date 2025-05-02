class Solution {
    public ListNode insertionSortList(ListNode head) {
        // Create a dummy node to serve as the head of the sorted list
        ListNode sortedHead = new ListNode(0);
        
        // Traverse the given list
        ListNode current = head;
        
        while (current != null) {
            // For each node in the unsorted list, find the correct position in the sorted list
            ListNode prev = sortedHead;
            
            // Find the correct position to insert the current node
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            // Insert the current node into the sorted list
            ListNode next = current.next;
            current.next = prev.next;
            prev.next = current;
            
            // Move to the next node in the original list
            current = next;
        }
        
        // Return the sorted list (excluding the dummy node)
        return sortedHead.next;
    }
}
