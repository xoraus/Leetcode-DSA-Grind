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
        int yes, no;
    }

    public Pair dfs(TreeNode root){
        if(root == null) return new Pair();

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        Pair curr = new Pair();
        curr.yes = root.val + left.no + right.no;
        curr.no = Math.max(left.yes, left.no) + Math.max(right.yes, right.no);
        return curr;
    }
    
    public int rob(TreeNode root) {
        Pair res = dfs(root);
        return Math.max(res.yes, res.no);
    }
}