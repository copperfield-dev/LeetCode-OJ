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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;

        int start = 0;
        int end = num.length - 1;

        TreeNode tree = constructBST(start, end, num);
        return tree;
    }

    public TreeNode constructBST(int start, int end, int[] num) {
        if (start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode temp = new TreeNode(num[mid]);
        temp.left = constructBST(start, mid - 1, num);
        temp.right = constructBST(mid + 1, end, num);
        return temp;
    }
}