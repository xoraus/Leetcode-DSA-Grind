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
        if (head == null)
            return null;

        Node l1 = head;
        // Create Cloned Nodes
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
        }

        l1 = head;
        // Clone Random Pointers
        while (l1 != null) {
            if (l1.random != null)
                l1.next.random = l1.random.next;
            l1 = l1.next.next;
        }

        // Detach Two Lists
        Node ans = head.next;
        l1 = head;
        Node l2 = head.next;
        while (l1 != null) {
            if (l1.next != null)
                l1.next = l1.next.next;
            if (l2.next != null)
                l2.next = l2.next.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        return ans;
    }

}