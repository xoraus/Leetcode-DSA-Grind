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
    int height = 0;
    boolean isBalanced = true;
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        Pair res = dfs(root);
        return res.isBalanced;
    }

    public Pair dfs(TreeNode root){
        if(root == null) return new Pair();

        Pair leftTree = dfs(root.left);
        Pair rightTree = dfs(root.right);

        Pair ans = new Pair();
        ans.height = Math.max(leftTree.height, rightTree.height) + 1;
        ans.isBalanced = leftTree.isBalanced && rightTree.isBalanced && Math.abs(leftTree.height - rightTree.height) <= 1;

        return ans;
    }
}