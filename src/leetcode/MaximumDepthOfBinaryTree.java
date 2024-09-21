package leetcode;

public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findDepth(1, root);
    }

    private int findDepth(int depth, TreeNode root) {
        if (root == null) {
            return depth;
        }
        if (root.left == null && root.right == null) {
            return depth;
        }
        return Math.max(findDepth(depth + 1, root.left), findDepth(depth + 1, root.right));
    }
}
