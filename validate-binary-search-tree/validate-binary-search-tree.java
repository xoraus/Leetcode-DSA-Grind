class Solution {
    public boolean validateBST(TreeNode root, long low, long high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;

        boolean isLeftBST = validateBST(root.left, low, root.val);
        boolean isRighBST = validateBST(root.right, root.val, high);

        return isLeftBST && isRighBST;
    }
    
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, (long)-1e15, (long)1e15);
    }
}