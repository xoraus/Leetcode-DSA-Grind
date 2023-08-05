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
    class Result {
        int prev;   
        int diff;

        Result(int prev, int diff) {
            this.prev = prev;
            this.diff = diff;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        Result result = new Result((int) -1e8, (int) 1e8);
        inorder(root, result);
        return result.diff;
    }

    public void inorder(TreeNode root, Result result) {
        if (root == null) return;

        inorder(root.left, result);
        result.diff = Math.min(result.diff, root.val - result.prev);
        result.prev = root.val;
        inorder(root.right, result);
    }


}