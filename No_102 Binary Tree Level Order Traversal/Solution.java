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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return answer;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelAnswer = new ArrayList<Integer>();
            int levelCount = queue.size();

            for (int i = 0; i < levelCount; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                levelAnswer.add(queue.poll().val);
            }
            answer.add(levelAnswer);
        }

        return answer;
    }
}