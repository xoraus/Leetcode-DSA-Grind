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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Calculate the length of the linked list and find the tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k to handle cases where k > length
        k %= length;

        if (k == 0) {
            return head;
        }

        // Initialize fast and slow pointers
        ListNode fast = head;
        ListNode slow = head;

        // Move the fast pointer k steps ahead of the slow pointer
        for (int i = 0; i < k; i++) {
            fast = fast.next != null ? fast.next : head;
        }

        // Move both fast and slow pointers until the fast pointer reaches the tail
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Rotate the list
        tail.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
