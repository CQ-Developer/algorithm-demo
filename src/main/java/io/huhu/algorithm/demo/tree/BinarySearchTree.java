package io.huhu.algorithm.demo.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找代码实现
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入代码实现
     */
    public void insert(int data) {
        // 初始化一棵树
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        // 树已经初始化过
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public static class Node {

        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }

}
