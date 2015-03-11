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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        Map<Integer, Integer> hashMap= new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) 
            hashMap.put(inorder[i], i);

        return buildProcess(hashMap, preorder, 
            0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode buildProcess(Map<Integer, Integer> hashMap, int[] preorder, 
        int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = hashMap.get(preorder[preStart]);

        if (rootIndex == inStart)
            root.left = null;
        else
            root.left = buildProcess(hashMap, preorder, 
                preStart + 1, rootIndex - inStart, inStart, rootIndex - 1);
        if (rootIndex == inEnd)
            root.right = null;
        else
            root.right = buildProcess(hashMap, preorder, 
                preStart + rootIndex - inStart + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}