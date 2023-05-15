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
        Node dummy = new Node(-1);
        Node l1 = head, l2 = dummy;
        HashMap<Node, Node> mirror = new HashMap<>();

        while(l1 != null){
            l2.next = new Node(l1.val);
            mirror.put(l1, l2.next);
            l1 = l1.next;
            l2 = l2.next;
        }

        l1 = head; l2 = dummy.next;
        while(l1 != null){
            l2.random = mirror.get(l1.random);
            l1 = l1.next;
            l2 = l2.next;
        }

        return dummy.next;
        
    }
}