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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode node, long alpha, long beta) {
        if (node == null) 
            return true;

        if (alpha < node.val && node.val < beta)
            return isBST(node.left, alpha, node.val) 
                && isBST(node.right, node.val, beta);
        else
            return false;
    }
}