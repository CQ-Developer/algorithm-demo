package io.huhu.algorithm.demo.tree;

/**
 * 遍历二叉树
 */
public class BinaryTree {

    /**
     * 前序遍历
     * f(n) = print(n) + f(n.left) + f(n.right)
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * f(n) = f(n.left) + print(n) + f(n.right)
     */
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /**
     * 后续遍历
     * f(n) = f(n.left) + f(n.right) + print(n)
     */
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;
    }

}
