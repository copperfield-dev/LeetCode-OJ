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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        traversal(root, answer);
        return answer;
    }

    private void traversal(TreeNode tree, List<Integer> answer) {
        if (tree != null) {
            traversal(tree.left, answer);
            answer.add(tree.val);
            traversal(tree.right, answer);
        }
    }
}