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
    public int dfs(TreeNode root, boolean[] balanced){
        if(root == null) return 0;

        int lh = dfs(root.left, balanced);
        int rh = dfs(root.right, balanced);

        if(Math.abs(lh - rh) > 1) balanced[0] = false;
        return Math.max(lh, rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] balanced = {true};
        dfs(root, balanced);
        return balanced[0];
    }
}