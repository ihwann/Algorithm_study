package DataStructure;

import java.util.Scanner;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt(); // 이진트리에 삽입할 숫자의 수
        Tree root = null;

        while (tc-- > 0) {
            int data = sc.nextInt();
            root = insertTree(root, data);
        }

        int treeHeight = getHeight(root);
        System.out.println(treeHeight);
    }

    private static int getHeight(Tree root) {
        if (root == null) {
            return -1;
        } else {
            int leftDepth = getHeight(root.left) + 1;
            int rightDepth = getHeight(root.right) + 1;
            return (Math.max(leftDepth, rightDepth));
        }
    }

    private static Tree insertTree(Tree root, int data) {

        if (root == null) {
            return new Tree(data);
        } else {
            Tree cur;
            if (root.data < data) {
                cur = insertTree(root.right, data);
                root.right = cur;
            } else {
                cur = insertTree(root.left, data);
                root.left = cur;
            }
        }
        return root;
    }
}
