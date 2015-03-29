/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private LinkedList<TreeNode> treeStack = new LinkedList<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        while (root != null) {
            treeStack.push(root);
            root = root.left;
        }   
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !treeStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = treeStack.pop();
        int nextSmallest = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                treeStack.push(node);
                node = node.left;
            }
        }
        return nextSmallest;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */