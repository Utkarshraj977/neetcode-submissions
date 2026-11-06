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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode h=head;
        while(h!=null){
            len++;
            h=h.next;
        }
        if(len-n==0) return head.next;
        int count=0;
        h=head;
        ListNode prev=null;
        while(count < len-n){
            prev=h;
            h=h.next;
            count++;
        }
        prev.next=h.next;
        h.next=null;
        return head;
    }
}
