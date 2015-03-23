/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode dummyLessHead = new ListNode(Integer.MIN_VALUE);
        ListNode dummyGreaterHead = new ListNode(Integer.MAX_VALUE);
        ListNode less = dummyLessHead;
        ListNode greater = dummyGreaterHead;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                less.next = p;
                less = less.next;
            }
            else if (p.val >= x) {
                greater.next = p;
                greater = greater.next;
            }
            p = p.next;
        }
        greater.next = null;
        less.next = dummyGreaterHead.next;
        return dummyLessHead.next;
    }
}