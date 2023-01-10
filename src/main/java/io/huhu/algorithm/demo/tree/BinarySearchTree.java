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

    public static class Node {

        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }

}
