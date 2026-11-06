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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Break the link between the first and second half
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        // Step 3: Merge the two halves in-place
        ListNode first = head;
        ListNode second = prev; // Head of the reversed second half
        
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            // Stitch the nodes together
            first.next = second;
            second.next = temp1;
            
            // Move pointers forward
            first = temp1;
            second = temp2;
        }
    }
}
