class Pair {
    TreeNode node;
    int position;

    Pair(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
}

class Solution {
    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.addLast(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftMostPosition = queue.getFirst().position;
            int rightMostPosition = queue.getFirst().position;

            while (levelSize-- > 0) {
                Pair currPair = queue.removeFirst();
                rightMostPosition = currPair.position;

                if (currPair.node.left != null)
                    queue.addLast(new Pair(currPair.node.left, currPair.position * 2 + 1));

                if (currPair.node.right != null)
                    queue.addLast(new Pair(currPair.node.right, currPair.position * 2 + 2));
            }

            int levelWidth = rightMostPosition - leftMostPosition + 1;
            maxWidth = Math.max(maxWidth, levelWidth);
        }

        return maxWidth;
    }
}
