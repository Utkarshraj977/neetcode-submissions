class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode beforeStart = dummy; // Yeh har group ke theek pehle wale node ko track karega
        ListNode end = head;          // Yeh har group ke aakhri node ko dhoondega
        
        int count = 0;
        while (end != null) {
            count++;
            
            // Jaise hi hume 'k' nodes ka group milta hai
            if (count % k == 0) {
                ListNode start = beforeStart.next; // Group ka pehla node
                ListNode afterEnd = end.next;       // Agle group ka pehla node (Saves the bridge)
                
                // 1. Is group ko reverse karo
                reverse(start, afterEnd);
                
                // 2. Ab links ko wapas sahi jodo
                beforeStart.next = end;  // Pehle wale node ko ab naye head (jo ki 'end' tha) se jodo
                start.next = afterEnd;   // Naye tail (jo ki 'start' tha) ko agle group se jodo
                
                // 3. Pointers ko agle group ke liye set karo
                beforeStart = start;
                end = afterEnd;
            } else {
                end = end.next;
            }
        }
        
        return dummy.next;
    }
    
    // Helper function: Kisi specific range [start, afterEnd) tak ke nodes ko reverse karne ke liye
    private void reverse(ListNode start, ListNode afterEnd) {
        ListNode prev = null;
        ListNode curr = start;
        
        while (curr != afterEnd) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
    }
}
