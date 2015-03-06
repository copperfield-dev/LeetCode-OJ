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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)   
            return head;

        ListNode p = head;
        ListNode q = head;
        while (p.next != null) {
            if (n == 0) {
                q = q.next;
                p = p.next;
            }
            else {
                p = p.next;
                n--;
            }
        }
        /* n只能为1或者0 */
        if (n == 1)
            head = head.next;       //n = 1, 删除头结点
        else
            q.next = q.next.next;   //n = 0, 删除q所指向的结点
        return head;
    }
}