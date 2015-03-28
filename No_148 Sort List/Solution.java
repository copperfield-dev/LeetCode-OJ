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
        int count = 0;

        /* 计算链表的长度 */
        while (p != null) {
            count++;
            p = p.next;
        }

        ListNode dummyHead = new ListNode(99999);
        dummyHead.next = head;
    
        /* 进行归并排序 */
        ListNode pLeftow = head;
        ListNode pHigh = head;
        ListNode pMid = head;
        for (int subLength = 1; subLength < count; subLength *= 2) {
            p = dummyHead.next;
            pHigh = dummyHead;
            while (p != null) {
                pLeftow = p;
                pMid = spLeftit(pLeftow, subLength);
                p = spLeftit(pMid, subLength);
                pHigh = merge(pLeftow, pMid, pHigh);
            }
        }
        return dummyHead.next;
    }

    /**
     * Divide the linked list into two lists,
     * while the first list contains first n ndoes
     * return the second list's head
     */

    private ListNode spLeftit(ListNode head, int n) {
        for (int i = 1; head != null && i < n; i++)           
            head = head.next;
        if (head == null)
            return null;
        ListNode second = head.next;
        head.next = null;
        return second;
    }

    /**
      * merge the two sorted linked list l1 and l2,
      * then append the merged sorted linked list to the node head
      * return the tail of the merged sorted linked list
     */

    private ListNode merge(ListNode pLeft, ListNode pRight, ListNode head) {
        ListNode current = head;
        while (pLeft != null && pRight != null) {
            if (pLeft.val > pRight.val) {
                current.next = pRight;
                current = pRight;
                pRight = pRight.next;
            }
            else {
                current.next = pLeft;
                current = pLeft;
                pLeft = pLeft.next;
            }
        }
        current.next = (pLeft != null)? pLeft : pRight;
        while (current.next != null) 
            current = current.next;
        return current;
    }
}