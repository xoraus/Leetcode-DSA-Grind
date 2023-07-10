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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1, size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int idx = 0; idx < size; idx++){
                TreeNode removed = queue.remove();
                if(removed == null) continue;
                if(removed.left == null && removed.right == null) return depth;
                queue.add(removed.left);
                queue.add(removed.right);
            }
            depth++;
        }
        return 0;
    }
}