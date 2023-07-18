/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        findNodes(root, target, k, result);
        return result;
    }

    public int findNodes(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root == null) return -1;
        if (root == target) {
            dfs(root, k, result);
            return 1;
        }

        int leftDist = findNodes(root.left, target, k, result);
        if (leftDist >= 0) {
            dfs(root.right, k - leftDist - 1, result);
            if (leftDist == k) result.add(root.val);
            return leftDist + 1;
        }

        int rightDist = findNodes(root.right, target, k, result);
        if (rightDist >= 0) {
            dfs(root.left, k - rightDist - 1, result);
            if (rightDist == k) result.add(root.val);
            return rightDist + 1;
        }

        return -1;
    }

    public void dfs(TreeNode root, int k, List<Integer> result) {
        if (root == null || k < 0) return;
        if (k == 0) result.add(root.val);
        dfs(root.left, k - 1, result);
        dfs(root.right, k - 1, result);
    }
}