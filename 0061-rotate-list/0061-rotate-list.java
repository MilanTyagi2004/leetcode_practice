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
    public static ListNode findNthNode(ListNode temp,int k){
        int cnt = 1;
        while(temp!=null){
            if(cnt ==k )return temp;
            temp = temp.next;
            cnt++;
        }
        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int len = 1;
        if(head==null||head.next==null)return head;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        if(k==0)return head;
        k=k%len;
        tail.next=head;

        ListNode newNthNode = findNthNode(head,len-k);
        head = newNthNode.next;
        newNthNode.next=null;
        return head;
    }
}