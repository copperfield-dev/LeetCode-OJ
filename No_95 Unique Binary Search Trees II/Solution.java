/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public ArrayList<TreeNode> generateTrees(int left, int right) {
        ArrayList<TreeNode> treeSet = new ArrayList<TreeNode>();
        if (left > right) {
            treeSet.add(null);
            return treeSet;
        }

        for (int i = left; i <= right; i++) {
            /* 以i作为根节点, 左子树由[1,i-1]构成 */
            ArrayList<TreeNode> leftTrees = generateTrees(left, i - 1);
            /* 以i作为根节点, 右子树由[i+1, n]构成 */
            ArrayList<TreeNode> rightTrees = generateTrees(i + 1, right);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    treeSet.add(root);
                }
            }
        }
        return treeSet;
    }
}