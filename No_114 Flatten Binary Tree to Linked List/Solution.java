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
    public void flatten(TreeNode root) {
        if (root == null)
            return null;
        flatten(root.left);
        flatten(root.right);
        TreeNode p = root;
        if (p.left == null)
            return;
        else
            p = p.left;
        while (p.right != null)
            p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}