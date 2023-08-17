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
    public boolean findTarget(TreeNode root, int target) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        
        ForwardIterator left = new ForwardIterator(root);
        BackwardIterator right = new BackwardIterator(root);
        
        while (left.hasNext() && right.hasPrev() && left.peek() < right.peek()) {
            if (left.peek() + right.peek() == target) return true;
            if (left.peek() + right.peek() < target) left.next();
            else right.prev();
        }
        
        return false;
    }

    static class ForwardIterator {
        Stack<TreeNode> stack;

        public ForwardIterator(TreeNode root) {
            stack = new Stack<>();
            inorderSuccessor(root);
        }

        public void inorderSuccessor(TreeNode current) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        public int peek() {
            if (!hasNext()) {
                return 0;
            }
            return stack.peek().val;
        }

        public int next() {
            if (!hasNext()) {
                return 0;
            }
            TreeNode current = stack.pop();
            inorderSuccessor(current.right);
            return current.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    static class BackwardIterator {
        Stack<TreeNode> stack;

        public BackwardIterator(TreeNode root) {
            stack = new Stack<>();
            inorderPredecessor(root);
        }

        public void inorderPredecessor(TreeNode current) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
        }

        public int peek() {
            if (!hasPrev()) {
                return 0;
            }
            return stack.peek().val;
        }

        public int prev() {
            if (!hasPrev()) {
                return 0;
            }
            TreeNode current = stack.pop();
            inorderPredecessor(current.left);
            return current.val;
        }

        public boolean hasPrev() {
            return !stack.isEmpty();
        }
    } 
}

