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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(-1);
        ListNode t=ans;
        ListNode curr1=l1;
        ListNode curr2=l2;
        int p=0;
        while(curr1!=null && curr2!=null){
            int v=curr1.val+curr2.val+p;
            p=v/10;
            v=v%10;
            ans.next=new ListNode(v);
            ans=ans.next;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        while(curr1!=null){
            int v=curr1.val+p;
            p=v/10;
            v=v%10;
            ans.next=new ListNode(v);
            ans=ans.next;
            curr1=curr1.next;
        }
        while(curr2!=null){
            int v=curr2.val+p;
            p=v/10;
            v=v%10;
            ans.next=new ListNode(v);
            ans=ans.next;
            curr2=curr2.next;
        }
        if(p>0) ans.next=new ListNode(p);
        return t.next;
    }
}
