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
    public ListNode partition(ListNode curr, int pivot) {
        ListNode dummyA = new ListNode(-1);
        ListNode tailA = dummyA;
        
        ListNode dummyB = new ListNode(-1);
        ListNode tailB = dummyB;

        while(curr != null){
            if(curr.val < pivot){
                tailA.next = curr;
                tailA = curr;
                curr = curr.next;
            } else {
                tailB.next = curr;
                tailB = curr;
                curr = curr.next;
            }
        }

        tailA.next = dummyB.next;
        tailB.next = null;
        
        return dummyA.next;
    }
}