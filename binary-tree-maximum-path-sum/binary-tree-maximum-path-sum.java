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
    public static class Pair {
        int height = 0;
        int maxPathSum = Integer.MIN_VALUE;
    }

    public Pair calcMaxPathSum(TreeNode root) {
        if (root == null)
            return new Pair();

        Pair leftPair = calcMaxPathSum(root.left);
        Pair rightPair = calcMaxPathSum(root.right);

        leftPair.height = Math.max(0, leftPair.height);
        rightPair.height = Math.max(0, rightPair.height);

        Pair currPair = new Pair();
        currPair.maxPathSum = Math.max(leftPair.maxPathSum, rightPair.maxPathSum);
        currPair.maxPathSum = Math.max(currPair.maxPathSum,
                leftPair.height + rightPair.height + root.val);

        currPair.height = Math.max(leftPair.height, rightPair.height) + root.val;
        return currPair;
    }

    public int maxPathSum(TreeNode root) {
        Pair resultPair = calcMaxPathSum(root);
        return resultPair.maxPathSum;
    }
}