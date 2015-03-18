/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next == null)
            return;

        ListNode pFast = head;
        ListNode pSlow = head;

        while (pFast.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }

        ListNode dummyFormerHead = new ListNode(999);
        ListNode dummyLatterHead = new ListNode(999);
        dummyFormerHead.next = head;
        dummyLatterHead.next = pSlow.next;

        /* 翻转后半部分的数组 */
        ListNode p = dummyLatterHead;
        ListNode temp = dummyLatterHead.next;
        while (p.next != null) 
            p = p.next;
        while (temp != p) {
            dummyLatterHead.next = temp.next;
            temp.next = p.next;
            p.next = temp;
            temp = dummyLatterHead.next;
        }

        /* 合并两个数组 */
        pFast = dummyFormerHead.next;
        pSlow = dummyLatterHead.next;

        while (pSlow != null) {
            temp = pSlow;
            pSlow = pSlow.next;
            temp.next = pFast.next;
            pFast.next = temp;
            pFast = pFast.next.next;
        }
        dummyLatterHead.next = null;
        pFast.next = null;
        
        head = dummyFormerHead.next;
    }
}