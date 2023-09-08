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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to swap if the list is empty or has only one node.
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            
            // Swapping adjacent nodes
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            current.next = secondNode;
            
            current = current.next.next; // Move to the next pair of nodes.
        }

        return dummy.next;
    }
    
}