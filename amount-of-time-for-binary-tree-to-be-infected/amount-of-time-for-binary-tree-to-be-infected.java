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
    int maxTime = 0;

    public void dfs(TreeNode root, int time){
        if(root == null) return;
        maxTime = Math.max(maxTime, time);

        dfs(root.left, time + 1);
        dfs(root.right, time + 1);
    }

    public int find(TreeNode root, int target){
        if(root == null) return -1;
        if(root.val == target){
            dfs(root, 0);return 1;
        }

        int left = find(root.left, target);
        if(left > 0){
            maxTime = Math.max(maxTime, left);
            dfs(root.right, left + 1);
            return 1 + left;
        }

        int right = find(root.right, target);
        if(right > 0){
            maxTime = Math.max(maxTime, right);
            dfs(root.left, right + 1);
            return 1 + right;
        }

        return -1;
    }

    public int amountOfTime(TreeNode root, int target) {
        find(root, target);
        return maxTime;
    }
}