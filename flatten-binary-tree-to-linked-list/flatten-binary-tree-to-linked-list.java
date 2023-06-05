class Solution {
    public static class Pair{
        TreeNode head, tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }

    public Pair linearize(TreeNode root){
        if(root == null){
            return new Pair(null, null);
        }

        if(root.left == null && root.right == null){
            return new Pair(root, root);
        }

        if(root.left == null){
            Pair rightList = linearize(root.right);
            return new Pair(root, rightList.tail);
        } 

        Pair leftList = linearize(root.left);
        Pair rightList = linearize(root.right);

        root.left = null;
        root.right = leftList.head;
        if(rightList.head == null){
            return new Pair(root, leftList.tail);
        }
        leftList.tail.right = rightList.head;
        return new Pair(root, rightList.tail);
    }

    public void flatten(TreeNode root) {
        linearize(root);
    }
}