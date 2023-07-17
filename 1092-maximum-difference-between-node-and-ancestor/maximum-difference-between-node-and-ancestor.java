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
    public  int findMaxDiff(TreeNode root, int minV, int maxV){
        if(root == null) return Math.abs(minV - maxV);
        
        minV = Math.min(minV, root.val);
        maxV = Math.max(maxV, root.val);
        
        int leftTree = findMaxDiff(root.left, minV, maxV);
        int rightTree = findMaxDiff(root.right, minV, maxV);
        
        return Math.max(leftTree, rightTree);
    }

    public int maxAncestorDiff(TreeNode root) {
        return findMaxDiff(root, root.val, root.val);    
    }
}