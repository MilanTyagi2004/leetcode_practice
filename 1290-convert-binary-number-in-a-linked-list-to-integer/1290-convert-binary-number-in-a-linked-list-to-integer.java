class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        
        // Traverse through the linked list
        ListNode current = head;
        while (current != null) {
            // Shift left by 1 (multiply by 2) and add the current node value (0 or 1)
            result = result * 2 + current.val;
            current = current.next;
        }
        
        return result;
    }
}
