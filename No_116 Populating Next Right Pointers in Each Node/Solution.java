/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode p = root;
        p.next = null;
    
        while (p.left != null) {
            TreeLinkNode pNextLevel = p.left;

            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) 
                    p.right.next = p.next.left;
                else
                    p.right.next = null;
                p = p.next;  
            }
            p = pNextLevel;
        }
    }
}