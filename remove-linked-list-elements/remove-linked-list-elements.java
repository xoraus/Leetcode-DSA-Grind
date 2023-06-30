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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;

        while(head != null){
            if(head.val == val){
                head = head.next;
            } else {
                tail.next = head;
                tail = head;
                head = head.next;
            }
        }

        tail.next = null;
        return dummy.next;
    }
}