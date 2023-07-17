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

class Pair {
    int height;
    boolean isBalanced;

    public Pair(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        Pair res = dfs(root);
        return res.isBalanced;
    }

    public Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        return new Pair(height, isBalanced);
    }
}
