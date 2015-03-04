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
    public boolean isBalanced(TreeNode root) {
        if (root == null) 
            return true;

        int leftDepth = heightTree(root.left);
        int rightDepth = heightTree(root.right);
        int diff = leftDepth - rightDepth;
        if (Math.abs(diff) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int heightTree(TreeNode tree) {
        if (tree == null)
            return -1;
        else
            return 1 + Math.max(heightTree(tree.left),
                                heightTree(tree.right));
    } 
}