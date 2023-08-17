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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();

        while (root != null) {
            if (root.left == null) {
                preorder.add(root.val);
                inorder.add(root.val);
                root = root.right;
                continue;
            }

            TreeNode floor = findFloor(root);
            while (floor.right != null && floor.right != root) {
                floor = floor.right;
            }

            if (floor.right == null) {
                floor.right = root; // Thread creation
                preorder.add(root.val);
                root = root.left;
            } else {
                floor.right = null; // Thread deletion
                inorder.add(root.val);
                root = root.right;
            }
        }

        return preorder;
    }

    public TreeNode findFloor(TreeNode root) {
        TreeNode floorNode = root.left;
        
        while (floorNode.right != null && floorNode.right != root) {
            floorNode = floorNode.right;
        }
        
        return floorNode;
    }
}