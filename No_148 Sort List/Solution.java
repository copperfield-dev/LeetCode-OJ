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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode pMin = head;
        int N = 1;

        /* 计算链表的长度并把最小值结点移到链表头充当头结点 */
        while (p.next != null) {
            if (p.next.val < pMin.val)
                pMin = p;
            N++;
            p = p.next;
        }
        if (pMin != head) {
            ListNode temp = pMin.next;
            pMin.next = pMin.next.next;
            temp.next = head;
            head = temp;
        }

        /* 进行归并排序 */
        ListNode pLow = head.next, pHigh = head.next;
        ListNode pMid = head.next;
        for (int subLength = 1; subLength < N; subLength *= 2) {
            int low = 1;
            while (low < N - subLength) {
                for (int i = 0; i < low + subLength - 1; i++)                 
                    pMid = pMid.next;
                for (int j = 0; j < Math.min(low + 2 * subLength - 1, N - 1); j++) 
                    pHigh = pHigh.next;
                merge(pLow, pMid, pHigh);
                low += subLength * 2;
                for (int k = 0; k < subLength * 2; k++) 
                    pLow = pLow.next;
            }
        }
        return head;
    }

    public ListNode merge(ListNode pLow, ListNode pMid, ListNode pHigh) {
        ListNode p = pLow, q = pMid.next;
        ListNode dummyHead = new ListNode(99999);
        ListNode current = dummyHead;

        while (p != pMid.next && q != pHigh.next) {
            if (p.val < q.val) {
                current = p;
                p = p.next;
            }
            else {
                current.next = q;
                q = q.next;
            }
            current = current.next;
        }
        current.next = (p == pMid.next)? q : p;
        return dummyHead.next;
    }
}

