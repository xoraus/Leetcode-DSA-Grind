/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        if(root.left == null){
            return minDepth(root.right) + 1;
        }

        int minLeftHeight = minDepth(root.left);
        int minRightHeight = minDepth(root.right);
        return 1 + Math.min(minLeftHeight, minRightHeight);
    }
}