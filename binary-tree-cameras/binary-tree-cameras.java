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
    public static enum State{
        COVERED, CAMERA, NEED;
    }
    
    int cameras = 0;

    public State dfs(TreeNode root){
        if(root == null) return State.COVERED;

        State leftSide = dfs(root.left);
        State rightSide = dfs(root.right);

        if(leftSide == State.NEED || rightSide == State.NEED){
            cameras++;
            return State.CAMERA;
        }

        if(leftSide == State.COVERED && rightSide == State.COVERED){
            return State.NEED;
        }

        return State.COVERED;
    }

    public int minCameraCover(TreeNode root) {
        if(dfs(root) == State.NEED){
            cameras++;
        }
        return cameras;
    }
}