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
    public ListNode oddEvenList(ListNode head) {
        // Edge case: empty list or a list with only one element
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddPointer = head;      // Pointer for odd nodes
        ListNode evenPointer = head.next; // Pointer for even nodes
        ListNode evenHead = evenPointer;  // Head of the even nodes

        while (evenPointer != null && evenPointer.next != null) {
            // Adjust odd nodes
            oddPointer.next = oddPointer.next.next;
            oddPointer = oddPointer.next;

            // Adjust even nodes
            evenPointer.next = evenPointer.next.next;
            evenPointer = evenPointer.next;
        }

        // Connect the last odd node to the head of the even nodes
        oddPointer.next = evenHead;

        return head;
    }
}
