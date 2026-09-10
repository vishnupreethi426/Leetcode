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
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);

        while (head != null) {

            ListNode temp = head;
            head = head.next;

            ListNode current = dummy;

            while (current.next != null && current.next.val < temp.val) {
                current = current.next;
            }

            temp.next = current.next;
            current.next = temp;
        }

        return dummy.next;
    }
}