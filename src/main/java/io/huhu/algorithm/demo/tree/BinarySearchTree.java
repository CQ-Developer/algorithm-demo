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
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
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
        Node n = tree;
        while (n != null) {
            if (data > n.data) {
                if (n.right == null) {
                    n.right = new Node(data);
                    return;
                }
                n = n.right;
            } else {
                if (n.left == null) {
                    n.left = new Node(data);
                    return;
                }
                n = n.left;
            }
        }
    }

    /**
     * 删除代码实现
     * 1: 要删除的节点没有子节点, 将父节点中指向要删除节点的引用置为null
     * 2: 要删除的节点有1个子节点, 将父节点中指向要删除节点的引用指向要删除节点的子节点
     * 3: 要删除的节点有2个子节点, 将要删除节点的右子树中的最小节点替换到要删除节点的位置上, 再删除这个最小子节点
     */
    public void delete(int v) {
        // 待删除节点
        Node d = tree;
        // 待删除节点的父节点
        Node p = null;

        // 找到当前节点以及它的父节点
        while (d != null && d.data != v) {
            p = d;
            if (v > p.data) d = d.right;
            else d = d.left;
        }

        // 没有找到的情况
        if (d == null) return;

        // 待删除节点有2个子节点
        if (d.left != null && d.right != null) {
            // 右子树的最小节点
            Node mc = d.right;
            // 右子树最小节点的父节点
            Node mp = d;
            // 找到待删除节点右子树的最小节点
            while (mc.left != null) {
                mp = mc;
                mc = mp.left;
            }
            // 将待删除节点的数据替换为最小节点的数据
            // 这相当于已经删除了待删除节点
            d.data = mc.data;
            // 下面需要删除最小子节点
            d = mc;
            p = mp;
        }

        // 删除节点
        // 此时待删除节点的子节点必然只有1个或没有子节点
        Node c;
        // 找到待删除节点的子节点
        if (d.left != null) c = d.left;
        else if (d.right != null) c = d.right;
        else c = null;

        // 删除节点
        // 父节点为null表示待删除节点是根节点
        if (p == null) tree = c;
        else if (p.left == d) p.left = c;
        else p.right = c;
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
