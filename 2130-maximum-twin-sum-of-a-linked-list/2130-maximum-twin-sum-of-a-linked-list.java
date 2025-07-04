/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast==null) break;
            slow=slow.next;
        }
        ListNode tempHead=slow.next;
        ListNode newtempHead = reverse(tempHead);
        int maxSum=0;
        while(newtempHead!=null){
            maxSum=Math.max(maxSum,newtempHead.val+head.val);
            head=head.next;
            newtempHead=newtempHead.next;
        }
        return maxSum;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head;
        while(next!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}