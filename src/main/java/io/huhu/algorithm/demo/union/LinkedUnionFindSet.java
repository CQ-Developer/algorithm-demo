package io.huhu.algorithm.demo.union;

/**
 * 并查集
 */
public class LinkedUnionFindSet {

    private final Node[] nodes;

    public LinkedUnionFindSet(int n) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }

    /**
     * 将对象i和对象j所属的集合合并在一起
     */
    void union(int i, int j) {
        if (find(i, j)) return;

        Node iHead = nodes[i].R;
        Node jHead = nodes[j].R;
        Node iTail = iHead.prev;
        Node jTail = jHead.prev;

        iTail.next = jHead;
        jHead.prev = iTail;

        jHead.next = iHead;
        iHead.prev = jTail;

        Node p = jHead;
        while (p != jTail) {
            p.R = iHead.R;
            p = p.next;
        }
        jTail.R = iHead.R;
    }

    /**
     * 查询对象i和对象j是否属于同一个集合
     */
    boolean find(int i, int j) {
        return nodes[i].R == nodes[j].R;
    }

    public static class Node {
        private Node prev = this;
        private Node next = this;
        private Node R = this;
    }

}
