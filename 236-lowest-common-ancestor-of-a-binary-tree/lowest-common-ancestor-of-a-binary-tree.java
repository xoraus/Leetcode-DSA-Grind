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
    public TreeNode lowestCommonAncestor(TreeNode currentNode, TreeNode node1, TreeNode node2) {
        if (currentNode == null) return null; // Case: Node not found
        
        if (currentNode == node1 || currentNode == node2) return currentNode; // Case: Either node1 or node2 found
        
        TreeNode leftLCA = lowestCommonAncestor(currentNode.left, node1, node2);
        TreeNode rightLCA = lowestCommonAncestor(currentNode.right, node1, node2);

        if (leftLCA != null && rightLCA != null) return currentNode; // Case: Both nodes found in different subtrees
        
        return (leftLCA != null) ? leftLCA : rightLCA; // Case: Either node1 or node2 found in one of the subtrees
    }

}