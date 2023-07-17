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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int goodNodesCount = 1;

        goodNodesCount += search(root.left, root.val);
        goodNodesCount += search(root.right, root.val);

        return goodNodesCount;
    }

    public int search(TreeNode root, int max){
        if(root == null) return 0;
        
        int count = 0;
        if(root.val >= max){
            count++;
            max = root.val;
        }

        count += search(root.left, max);
        count += search(root.right, max);

        return count;
    }
}