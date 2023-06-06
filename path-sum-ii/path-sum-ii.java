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
    List<List<Integer>> paths = new ArrayList<>();

    public void dfs(TreeNode root, int targetSum, List<Integer> path){
        if(root == null) return;

        targetSum -= root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == 0){
            paths.add(new ArrayList<>(path)); // deep copy
        }

        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        path.remove(path.size() - 1); // backtracking
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }
}