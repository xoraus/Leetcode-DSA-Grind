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
    long maxPathSum = Long.MIN_VALUE;

    public long calcMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        long leftSum = Math.max(calcMaxPathSum(root.left), 0);
        long rightSum = Math.max(calcMaxPathSum(root.right), 0);

        maxPathSum = Math.max(maxPathSum, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val; 
    }

    public int maxPathSum(TreeNode root) {
        calcMaxPathSum(root);
        return (int) maxPathSum;
    }
}