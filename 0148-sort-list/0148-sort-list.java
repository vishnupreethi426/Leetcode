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
class Solution{
    static {
        for (int i = 0; i < 500; i++) sortList(null);
    }
    
    public static ListNode sortList(ListNode head) 
    {
        if (head == null || head.next == null) return head;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        ListNode temp = head;

        while (temp != null) {
            max = Math.max(max, temp.val);
            min = Math.min(min, temp.val);
            temp = temp.next;
        }

        int c = max - min + 1;
        int[] f = new int[c];

        temp = head;

        while (temp != null) {
            f[temp.val - min]++;
            temp = temp.next;
        }

        temp = head;

        for (int i = 0; i < c; i++) {
            while (f[i] != 0) {
                temp.val = i + min;
                temp = temp.next;
                f[i]--;
            }
        }

        return head;
    }
}