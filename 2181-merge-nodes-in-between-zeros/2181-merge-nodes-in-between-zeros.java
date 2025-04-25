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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummynode = new ListNode(0);
        ListNode currentsumNode = dummynode;
        int sum = 0;

        ListNode temp = head.next;
        while(temp!=null){
            if(temp.val==0){
                currentsumNode.next = new ListNode(sum);
                currentsumNode = currentsumNode.next;
                sum=0;
            }else{
                sum+=temp.val;
            }
            temp = temp.next;
        } 
        return dummynode.next;
    }
}