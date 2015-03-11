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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    /* 自定义前序遍历 */
    public boolean isSymmetric(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null)
            return true;

        if (rootA == null || rootB == null)
            return false;

        if (rootA.val != rootB.val)
            return false;

        return isSymmetric(rootA.left, rootB.right)
            && isSymmetric(rootA.right, rootB.left);
    }
}