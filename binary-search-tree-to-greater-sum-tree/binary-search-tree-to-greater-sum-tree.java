class Solution {
    int sum = 0;

    public void dfs(TreeNode root){
        if(root == null) return;
        
        // reverse inorder traversal
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
}