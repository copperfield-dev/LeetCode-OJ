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
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        
        ListNode meetNode = meetNode(head);
        if (meetNode == null)
            return null;

        int nodesInLoop = 1;
        ListNode pAhead = meetNode;
        while(pAhead.next != meetNode) {
            pAhead = pAhead.next;
            ++nodesInLoop;
        }

        pAhead = head;
        for (int i = 0; i < nodesInLoop; i++) 
            pAhead = pAhead.next;
        ListNode pBehind = head;
        while (pAhead != pBehind) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pAhead;
    }

    public ListNode meetNode(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;

        while (pFast != null && pSlow != null) {
            if (pFast.next != null)
                pFast = pFast.next.next;
            else
                return null;
            pSlow = pSlow.next;
            
            if (pFast == pSlow)
                return pFast;
        }

        return null;
    }
}