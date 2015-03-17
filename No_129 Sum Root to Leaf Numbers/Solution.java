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
    public int sumNumbers(TreeNode root) {
        int currentSum = 0;
        return sum(root, currentSum);
    }

    public int sum(TreeNode node, int currentSum) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return currentSum * 10 + node.val;
        else
            return sum(node.left, currentSum * 10 + node.val) 
                 + sum(node.right, currentSum * 10 + node.val);
    }
}