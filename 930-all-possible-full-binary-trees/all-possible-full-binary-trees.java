public class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        return generateFBT(n);
    }

    public List<TreeNode> generateFBT(int n) {
        if (n == 1) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = generateFBT(i);
            List<TreeNode> rightSubtrees = generateFBT(n - i - 1);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}