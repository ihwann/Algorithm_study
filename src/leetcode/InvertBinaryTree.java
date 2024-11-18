package leetcode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        TreeNode result = root;

        if (result == null) {
            return null;
        }
        invert(root.left, root.right);

        return result;
    }

    private void invert(TreeNode left, TreeNode right) {
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;

        if (left.left != null && left.right != null) {
            invert(left.left, left.right);
        }
        if (right.left != null && right.right != null) {
            invert(right.left, right.right);
        }
    }
}
