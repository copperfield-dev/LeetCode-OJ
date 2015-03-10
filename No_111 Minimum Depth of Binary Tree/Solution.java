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
    public int minDepth(TreeNode root) {
        if (root != null)
            if (root.left != null && root.right != null)
                return 1 + Math.min(minDepth(root.left),
                    minDepth(root.right));
            else if (root.left == null || root.right == null)
                return 1 + minDepth(root.left) + minDepth(root.right);
            else 
                return 0;
        else
            return 0;
    }
}
