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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode p = head.next;
        ListNode cur = head;
        int curVal = cur.val;
        while (p != null) {
            if (p.val == curVal) {
                while (cur.next != null && cur.next.val == curVal) 
                    cur.next = cur.next.next;
                if (cur == head) 
                    head = cur.next;
                else {
                    ListNode q = head;
                    while (q.next.val != curVal) 
                        q = q.next;
                    q.next = q.next.next;
                }
                cur = cur.next;
                if (cur == null)
                    return head;
                curVal = cur.val;
                p = cur.next;
            }
            else {
                cur = cur.next;
                curVal = cur.val;
                p = p.next;
            }
        }
        return head;
    }
}