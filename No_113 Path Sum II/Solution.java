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
    private LinkedList<Integer> path = new LinkedList<Integer>();

    private List<List<Integer>> answer = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return answer;

        int currentSum = 0;
        findPath(root, sum, currentSum);
        return answer;
    }

    public void findPath(TreeNode root, int sum, int currentSum) {
        currentSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == sum) {
                List<Integer> subAnswer = new LinkedList<Integer>(path);
                answer.add(subAnswer);
            }
        }

        if (root.left != null)
            findPath(root.left, sum, currentSum);
        if (root.right != null)
            findPath(root.right, sum, currentSum);
            
        currentSum -= path.getLast();
        path.removeLast();
    } 
}