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
        int sum, tilt;
        Pair(int sum, int tilt){
            this.sum = sum;
            this.tilt = tilt;
        }
    }

    public Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, 0);
            
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int tilt = Math.abs(left.sum - right.sum) + left.tilt + right.tilt;
        int sum = left.sum + right.sum + root.val;
        
        return new Pair(sum, tilt);
    }

    public int findTilt(TreeNode root) {
        Pair res = dfs(root);
        return res.tilt;
    } 
}