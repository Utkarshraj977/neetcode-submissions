/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node h=head;
        Node t=new Node(-1);
        Node ans=t;
        while(h!=null){
            Node p=new Node(h.val);
            map.put(h,p);
            t.next=p;
            h=h.next;
            t=t.next;
        }
        h=head;
        t=ans.next;
        while(h!=null){
            t.random=map.get(h.random);
            t=t.next;
            h=h.next;
        }
        return ans.next;
    }
}

