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
        ListNode h = new ListNode(-1);
        ListNode ans = h;
        for (ListNode i : lists) {
            h.next = i;
            while(h.next!=null) h=h.next;
        }
        return mergesort(ans.next);
    }
    private ListNode split(ListNode node) {
        ListNode s = node;
        ListNode f = node.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode mid = s.next;
        s.next = null;
        return mid;
    }
    private ListNode mergesort(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode mid = split(node);
        ListNode l = mergesort(node);
        ListNode r = mergesort(mid);
        return merge(l, r);
    }
    private ListNode merge(ListNode l, ListNode r) {
        ListNode temp = new ListNode(-1);
        ListNode t = temp;
        while (l != null && r != null) {
            if (l.val < r.val) {
                temp.next = l;
                l = l.next;
            } else {
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        if (l != null)
            temp.next = l;
        else if (r != null)
            temp.next = r;
        return t.next;
    }
}
