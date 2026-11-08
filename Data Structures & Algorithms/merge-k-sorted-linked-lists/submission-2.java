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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=new ListNode(-1);
        ListNode h=ans;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode i:lists){
            if(i!=null)
            pq.add(i);
        }
        while(pq.size()>0){
            ListNode t=pq.remove();
            if(t.next!=null)
                pq.add(t.next);     
            h.next=t;
            h=h.next; 
        }
        return ans.next;
    }
}
