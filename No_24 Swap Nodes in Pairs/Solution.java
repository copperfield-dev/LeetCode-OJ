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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(9999);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode pLatter = head;
        ListNode pFormer = head.next;

        while (pFormer != null) {
            ListNode temp = pFormer.next;
            p.next = pFormer;
            pFormer.next = pLatter;
            pLatter.next = temp;
    
            p = p.next.next;
            if (p.next != null) {
                pLatter = p.next;
                pFormer = pLatter.next;
            }
            else 
                break;
        } 
        return dummyHead.next;
    }
}