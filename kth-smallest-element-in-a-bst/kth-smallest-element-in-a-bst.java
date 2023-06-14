class Solution {
    int count, ans = -1;

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        count--;
        if(count == 0) ans = root.val;
        inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inorder(root);
        return ans;    
    }
}