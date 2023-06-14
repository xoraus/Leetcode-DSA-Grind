class Solution {
    int prev = (int)-1e8, diff = (int)1e8;

    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        diff = Math.min(diff, root.val - prev);
        prev = root.val;
        inorder(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return diff;
    }
}