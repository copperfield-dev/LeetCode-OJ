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
    public List<LinkedList<Integer>> zigzagLevelOrder(TreeNode root) {
        List<LinkedList<Integer>> answer = new LinkedList<LinkedList<Integer>>();
        Queue<TreeNode> deQueue = new LinkedList<TreeNode>();
        if (root == null)
            return answer;

        int level = 1;
        deQueue.offer(root);
        while (!deQueue.isEmpty()) {
            LinkedList<Integer> levelAnswer = new LinkedList<Integer>();
            int levelCount = deQueue.size();

            for (int i = 0; i < levelCount; i++) {
                if (deQueue.peek().left != null)
                    deQueue.offer(deQueue.peek().left);
                if (deQueue.peek().right != null)
                    deQueue.offer(deQueue.peek().right);
                if ((level & 0x1) == 1)
                    levelAnswer.addLast(deQueue.poll().val);
                else
                    levelAnswer.addFirst(deQueue.poll().val);
            }
            answer.add(levelAnswer);
            level++;
        }
        return answer;
    }
}