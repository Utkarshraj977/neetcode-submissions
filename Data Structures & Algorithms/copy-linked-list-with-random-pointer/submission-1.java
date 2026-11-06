class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        
        // STEP 1: Original nodes ke theek aage unka clone insert karo
        while (curr != null) {
            Node nextNode = curr.next;
            Node cloneNode = new Node(curr.val);
            
            curr.next = cloneNode;
            cloneNode.next = nextNode;
            
            curr = nextNode; // Move to the next original node
        }
        
        // STEP 2: Random pointers ko map karo
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // curr.next hamara clone node hai
                // curr.random.next hamare random node ka clone hai
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }
        
        // STEP 3: Dono lists ko alag-alag (De-weave) karo
        curr = head;
        Node dummy = new Node(-1);
        Node cloneCurr = dummy;
        
        while (curr != null) {
            Node nextOriginal = curr.next.next;
            Node cloneNode = curr.next;
            
            // Clone list ko build karo
            cloneCurr.next = cloneNode;
            cloneCurr = cloneCurr.next;
            
            // Original list ke links ko restore karo
            curr.next = nextOriginal;
            
            curr = nextOriginal;
        }
        
        return dummy.next;
    }
}
