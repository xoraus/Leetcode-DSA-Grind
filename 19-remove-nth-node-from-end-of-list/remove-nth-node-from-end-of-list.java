/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head; // No modification needed for invalid input.
        }

        ListNode dummy = new ListNode(0); // Create a dummy node to simplify edge cases.
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move the fast pointer B+1 steps ahead.
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                // B is greater than or equal to the size of the list.
                // Remove the first node by updating the head.
                return head.next;
            }
            fast = fast.next;
        }

        // Move the slow and fast pointers together until the fast reaches the end.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the B-th node from the end by adjusting the pointers.
        slow.next = slow.next.next;

        return dummy.next; // Return the modified head of the list.
    }
}