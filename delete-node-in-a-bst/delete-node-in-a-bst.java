class Solution {
    public int floor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key > root.val) root.right = deleteNode(root.right, key);
        
        if(key == root.val){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            else {
                root.val = floor(root); 
                root.left = deleteNode(root.left, root.val);
                return root;
            }
        }
        
        return root;
    }
}
