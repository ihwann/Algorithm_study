package leetcode;

public class MinimumAbsoluteDifferenceInBst {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, null, new TreeNode(5, new TreeNode(3), null));
        System.out.println(getMinimumDifference(treeNode));
    }

    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return result;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            result = Math.min(result, Math.abs(root.val - root.left.val));
            dfs(root.left);
        }
        if (root.right != null) {
            result = Math.min(result, Math.abs(root.val - root.right.val));
            dfs(root.right);
        }
    }
}
