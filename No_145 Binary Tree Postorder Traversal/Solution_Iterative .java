}
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        boolean hasRightChild = true;                     //假设每一个结点都有右子树
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                if (hasRightChild) {
                    stack.push(root);
                    root = root.right;
                    hasRightChild = false;
                }
                else {
                    answer.add(root.val);
                    hasRightChild = true;
                }
            }
        }

        return answer;
    }
}