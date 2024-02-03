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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head, prev = null;

        // Fast should be k dist ahead of slow
        for (int idx = 0; idx < k; idx++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        // Handle the case where the node to be removed is the head
        if (fast == null) {
            return head.next;
        }

        // Sliding Window
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the Nth node
        prev.next = slow.next;

        return head;
    }

}