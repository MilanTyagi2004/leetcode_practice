class Solution {
    public ListNode modifiedList(int[] abc, ListNode li) {
        HashSet<Integer>set=new HashSet<>();
        for(int aa:abc)set.add(aa);
        ListNode t=li;
        while(t!=null && set.contains(t.val))t=t.next;
        if(t==null || t.next==null)return t;
        ListNode a=t;
        ListNode b=t.next;
        while(b!=null){
            if(set.contains(b.val))b=b.next;
            else{
                a.next=b;
                a=b;
                b=b.next;
            }
        }
        a.next=b;
        return t;
    }
}