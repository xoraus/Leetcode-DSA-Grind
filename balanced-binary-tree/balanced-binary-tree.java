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
    public static class Pair{
        int height = 0;
        boolean balanced = true;
    }
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair();

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        Pair curr = new Pair();
        curr.height = Math.max(left.height, right.height) + 1;
        curr.balanced = left.balanced && right.balanced;
        if(Math.abs(left.height - right.height) > 1) curr.balanced = false;
        return curr;
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }
}