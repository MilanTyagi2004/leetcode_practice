class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list using slow and fast pointers
        ListNode slow = head, fast = head;
        
        // Move slow pointer by 1 and fast pointer by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null; // End the first half of the list
        second = reverse(second);

        // Step 3: Merge the two halves
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Reorder nodes
            first.next = second;
            second.next = temp1;

            // Move the pointers forward
            first = temp1;
            second = temp2;
        }
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
