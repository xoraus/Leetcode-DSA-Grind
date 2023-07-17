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
    static class Pair {
        int height;
        int diameter;

        public Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).diameter;
    }

    public Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(left.diameter, right.diameter);
        diameter = Math.max(diameter, left.height + right.height);

        return new Pair(height, diameter);
    }
}
