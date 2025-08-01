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
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length and the tail
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Make the list circular
        current.next = head;

        // Step 3: Calculate the new tail position
        k = k % length;
        int stepsToNewTail = length - k;

        // Step 4: Find the new tail
        ListNode newTail = current;
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Set the new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
