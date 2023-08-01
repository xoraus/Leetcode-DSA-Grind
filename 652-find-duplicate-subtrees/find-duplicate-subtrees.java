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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicateSubtrees = new ArrayList<>();
        Map<String, Integer> subtreeFrequencyMap = new HashMap<>();
        dfsFindDuplicateSubtrees(root, subtreeFrequencyMap, duplicateSubtrees);
        return duplicateSubtrees;
    }

    private String dfsFindDuplicateSubtrees(TreeNode root, Map<String, Integer> subtreeFrequencyMap, List<TreeNode> duplicateSubtrees) {
        if (root == null) {
            return "N";
        }

        String leftSubtreeString = dfsFindDuplicateSubtrees(root.left, subtreeFrequencyMap, duplicateSubtrees);
        String rightSubtreeString = dfsFindDuplicateSubtrees(root.right, subtreeFrequencyMap, duplicateSubtrees);

        String currPath = String.valueOf(root.val) + "," + leftSubtreeString + "," + rightSubtreeString;
        int currFrequency = subtreeFrequencyMap.getOrDefault(currPath, 0);

        if (currFrequency == 1) {
            duplicateSubtrees.add(root);
        }

        subtreeFrequencyMap.put(currPath, currFrequency + 1);
        return currPath;
    }

}