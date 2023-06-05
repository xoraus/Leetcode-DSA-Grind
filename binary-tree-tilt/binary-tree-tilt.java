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
    int tiltSum = 0;
    public int subTreeSum(TreeNode root){
        if(root == null) return 0;

        int lsum = subTreeSum(root.left);
        int rsum = subTreeSum(root.right);

        int tilt = Math.abs(lsum - rsum);
        tiltSum += tilt;

        return (lsum + rsum + root.val);
    }
    public int findTilt(TreeNode root) {
        subTreeSum(root);
        return tiltSum;
    }
}