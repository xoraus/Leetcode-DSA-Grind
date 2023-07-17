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
        int height = 0;
        int diameter = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair ans = dfs(root);
        return ans.diameter;
    }

    public Pair dfs(TreeNode root) {
        if (root == null) return new Pair();

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        Pair ans = new Pair();
        ans.height = Math.max(l.height, r.height) + 1;
        ans.diameter = Math.max(l.diameter, r.diameter);
        ans.diameter = Math.max(ans.diameter,l.height + r.height);
        return ans;
    }
}