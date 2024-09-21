package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.set(0, 2);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        bfs(result, root);

        return result;
    }

    private void bfs(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = nodeQueue.poll();
                values.add(currentNode.val);

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                }
            }
            result.add(values.get(values.size() - 1));
        }
    }
}
