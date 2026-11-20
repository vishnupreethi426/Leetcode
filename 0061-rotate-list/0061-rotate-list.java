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

        if (head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode temp = head;

        // Find length and last node
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Connect last node to first node
        temp.next = head;

        // Find new last node
        int steps = length - k;
        temp = head;

        for (int i = 1; i < steps; i++) {
            temp = temp.next;
        }

        // Change the head
        head = temp.next;

        // Break the circular list
        temp.next = null;

        return head;
    }
}
