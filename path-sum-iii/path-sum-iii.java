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
    public int dfs(TreeNode root, long currSum, long targetSum, Map<Long, Integer> sumMap) {
        if (root == null) return 0;

        currSum += root.val;
        int count = sumMap.getOrDefault(currSum - targetSum, 0);

        sumMap.put(currSum, sumMap.getOrDefault(currSum, 0) + 1);

        count += dfs(root.left, currSum, targetSum, sumMap);
        count += dfs(root.right, currSum, targetSum, sumMap);

        sumMap.put(currSum, sumMap.get(currSum) - 1);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> sumMap = new HashMap<>();
        sumMap.put(0L, 1);  // Initialize with a running sum of 0

        return dfs(root, 0L, targetSum, sumMap);
    }
}

