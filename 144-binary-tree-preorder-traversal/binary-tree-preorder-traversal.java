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
    static class Pair {
        TreeNode root;
        int state = 1; // 1 -> preorder, 2 -> inorder, 3 -> postorder

        Pair(TreeNode root) {
            this.root = root;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<Pair> stk = new Stack<>();

        if (root != null) {
            stk.push(new Pair(root));
        }

        while (!stk.isEmpty()) {
            TreeNode currentRoot = stk.peek().root;

            if (stk.peek().state == 1) {
                // Preorder
                preorder.add(currentRoot.val);
                stk.peek().state++; // Next time: inorder
                if (currentRoot.left != null) {
                    stk.push(new Pair(currentRoot.left));
                }
            } else if (stk.peek().state == 2) {
                // Inorder
                stk.peek().state++; // Next time: postorder
                if (currentRoot.right != null) {
                    stk.push(new Pair(currentRoot.right));
                }
            } else {
                // Postorder
                stk.pop();
            }
        }
        return preorder;
    }
}