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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        Map<Integer, Integer> hashMap= new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) 
            hashMap.put(inorder[i], i);

        return buildProcess(hashMap, postorder, 
            0, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildProcess(Map<Integer, Integer> hashMap, int[] postorder, 
        int postStart, int postEnd, int inStart, int inEnd) {
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = hashMap.get(postorder[postEnd]);

        if (rootIndex == inStart)
            root.left = null;
        else
            root.left = buildProcess(hashMap, postorder, 
                postStart, postStart + rootIndex - inStart - 1, inStart, rootIndex - 1);
        if (rootIndex == inEnd)
            root.right = null;
        else
            root.right = buildProcess(hashMap, postorder, 
                postStart + rootIndex - inStart, postEnd - 1, rootIndex + 1, inEnd);

        return root;
    }
}