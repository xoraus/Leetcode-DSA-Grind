class Solution {
    int maxTime = 0;

    public int amountOfTime(TreeNode root, int target) {
        findTarget(root, target);
        return maxTime;
    }

    public int findTarget(TreeNode root, int target) {
        if (root == null) return -1;

        if (root.val == target) {
            calculateTime(root, 0);
            return 1; // distance from target to parent
        }

        int leftDist = findTarget(root.left, target);
        if (leftDist > 0) {
            maxTime = Math.max(maxTime, leftDist);
            calculateTime(root.right, leftDist + 1);
            return 1 + leftDist;
        }

        int rightDist = findTarget(root.right, target);
        if (rightDist > 0) { 
            maxTime = Math.max(maxTime, rightDist);
            calculateTime(root.left, rightDist + 1);
            return 1 + rightDist;
        }

        return -1;
    }

    public void calculateTime(TreeNode root, int time) {
        if (root == null) return;

        maxTime = Math.max(maxTime, time);

        calculateTime(root.left, time + 1);
        calculateTime(root.right, time + 1);
    }
}
