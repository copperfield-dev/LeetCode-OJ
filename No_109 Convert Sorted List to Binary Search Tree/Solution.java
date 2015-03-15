/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode pStart = head;
        TreeNode tree = constructBST(pStart);
        return tree;
    }

    public TreeNode constructBST(ListNode pStart) {
        if (pStart == null)
            return null;

        ListNode dummyHead = new ListNode(999);
        dummyHead.next = pStart;
        ListNode p = dummyHead;     //用于指向中间结点的前一个结点
        ListNode pMid = pStart;
        ListNode pFast = pStart;
        while (pMid.next != null && pFast.next != null && pFast.next.next != null) {
            p = p.next;
            pMid = pMid.next;
            pFast = pFast.next.next;
        }

        TreeNode temp = new TreeNode(pMid.val);
        if (pMid == pStart ) {
            if (pMid.next == null) {
                temp.left = null;
                temp.right = null;
            }
            else {
                temp.left = null;
                temp.right = constructBST(pMid.next);
            }
        }
        else {
            p.next = null;
            temp.left = constructBST(pStart);
            temp.right = constructBST(pMid.next);
        }
        
        return temp;
    }
}