class Solution {
    static class Pair{
        TreeNode head, tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public Pair linear(TreeNode root){
        if(root == null){
            return new Pair(null, null);
        }

        if(root.left == null && root.right == null){
            return new Pair(root, root);
        }

        if(root.left == null){
            Pair rightList = linear(root.right);
            return new Pair(root, rightList.tail);
        }

        if(root.right == null){
            Pair leftList = linear(root.left);
            root.left = null;
            root.right = leftList.head;
            return new Pair(root, leftList.tail); 
        }


        Pair leftList = linear(root.left);
        Pair rightList = linear(root.right);

        root.left = null;
        root.right = leftList.head;
        leftList.tail.right = rightList.head;

        return new Pair(root, rightList.tail);
    }

    public void flatten(TreeNode root) {
        linear(root);
    }
}