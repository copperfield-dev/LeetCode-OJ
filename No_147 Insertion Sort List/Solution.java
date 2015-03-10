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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(99999);
        dummyHead.next = head;
        ListNode p = head;
        while (p.next != null && p != null) {
            ListNode q = dummyHead;
            while (q.next != p && p.next.val >= q.next.val) 
                q = q.next;

            if ((q.next == p && p.next.val < q.next.val) 
                || q.next != p) {
                ListNode temp = p.next;
                p.next = p.next.next;
                temp.next = q.next;
                q.next = temp;
            }
            else
                p = p.next;
        }
        return dummyHead.next;
    }
}