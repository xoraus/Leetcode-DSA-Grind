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
**/
public class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = Integer.toString(root.val);
        String leftSubtree = tree2str(root.left);
        String rightSubtree = tree2str(root.right);

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.right == null) {
            return result + "(" + leftSubtree + ")";
        }

        if (root.left == null) {
            return result + "()" + "(" + rightSubtree + ")";
        }

        return result + "(" + leftSubtree + ")" + "(" + rightSubtree + ")";
    }
}
