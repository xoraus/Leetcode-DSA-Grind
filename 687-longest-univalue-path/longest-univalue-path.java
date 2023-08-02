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
    int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        findLongestPath(root);
        return maxPath;
    }

    private int findLongestPath(TreeNode node) {
        if (node == null) return 0;

        // Recursively find longest paths for the left and right subtrees
        int leftPath = findLongestPath(node.left);
        int rightPath = findLongestPath(node.right);

        // If the left child has the same value as the current node
        // and it forms part of the longest univalue path
        int leftUnivaluePath = 0;
        if (node.left != null && node.left.val == node.val) {
            leftUnivaluePath = leftPath + 1;
        }

        // If the right child has the same value as the current node
        // and it forms part of the longest univalue path
        int rightUnivaluePath = 0;
        if (node.right != null && node.right.val == node.val) {
            rightUnivaluePath = rightPath + 1;
        }

        // Update the maxPath if the current node can be part of a longer univalue path
        maxPath = Math.max(maxPath, leftUnivaluePath + rightUnivaluePath);

        // Return the maximum path length that can be extended from the current node
        return Math.max(leftUnivaluePath, rightUnivaluePath);
    }
}