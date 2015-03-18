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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 0)
            return head;

        ListNode dummyHead = new ListNode(99999);
        dummyHead.next = head;
        ListNode p = dummyHead, q = dummyHead;
        int listLen = 0;
        while (p.next != null) {
            p = p.next;
            listLen++;
        }
        int newK = (k % listLen == 0)? listLen: k % listLen;
        p = dummyHead;
        for (int i = 0; i < newK; i++) {
            if (p.next == null)
                p = dummyHead;
            else
                p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        ListNode temp = q.next;
        q.next = null;
        p.next = dummyHead.next;
        dummyHead.next = temp;
        return dummyHead.next;
    }
}