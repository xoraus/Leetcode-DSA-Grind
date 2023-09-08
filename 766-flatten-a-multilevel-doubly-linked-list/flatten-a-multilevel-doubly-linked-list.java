/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

public class Solution {
    private Node flattenRecursively(Node head) {
        Node current = head, tail = head;
        
        while (current != null) {
            Node child = current.child;
            Node next = current.next;
            
            if (child != null) {
                Node childTail = flattenRecursively(child);
                childTail.next = next;
                
                if (next != null) {
                    next.prev = childTail;
                }
                
                current.next = child;
                child.prev = current;
                current.child = null;
                tail = childTail;
            } else {
                tail = current;
            }
            
            current = next;
        }
        
        return tail;
    }

    public Node flatten(Node head) {
        if (head != null) {
            flattenRecursively(head);
        }
        
        return head;
    }
}
