class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1;
        for (int i = 1; i < a; i++) {
            prev = prev.next;
        }
        
        ListNode after = prev;
        for (int i = a - 1; i <= b; i++) {
            after = after.next;
        }
        
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        
        prev.next = list2;
        tail2.next = after;
        
        return list1;
    }
}