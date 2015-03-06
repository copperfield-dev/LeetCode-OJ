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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthOfA = 0;
        int lengthOfB = 0;
        if (headA == null)
            return null;
        lengthOfA++;
        if (headB == null)
            return null;
        lengthOfB++;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.next != null) {
            lengthOfA++;
            pA = pA.next;
        }
        while (pB.next != null) {
            lengthOfB++;
            pB = pB.next;
        }
        int gap = Math.abs(lengthOfA - lengthOfB);
        pA = headA;
        pB = headB;
        if (lengthOfA >= lengthOfB) {
            while (gap > 0) {
                pA = pA.next;
                gap--;
            }
        }
        else {
            while (gap > 0) {
                pB = pB.next;
                gap--;
            }
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pB;
    }
}