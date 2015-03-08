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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode pM = head, pN = head;
        ListNode pBeforeM = head;             //作为锚点使用

        for (int i = 1; i < n; i++) 
            pN = pN.next;
        for (int j = 1; j < m - 1; j++) 
            pBeforeM = pBeforeM.next;
        if (m > 1)
            pM = pBeforeM.next;

        if (m == 1) {
            ListNode temp = new ListNode(99999);
            temp.next = pM;
            pBeforeM = temp;
        }
            
        while (pM != pN && pM !=null && pN != null) {
            pBeforeM.next = pM.next;
            pM.next = pN.next;
            pN.next = pM;                   //插入结点时要注意改变指针的顺序
            pM = pBeforeM.next;
        }

        if (m == 1)
            return pBeforeM.next;
        else
            return head;
    }
}