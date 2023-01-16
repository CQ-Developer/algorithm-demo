package io.huhu.algorithm.demo.union;

/**
 * 基于树实现的并查集
 */
public class TreeUnionFindSet {

    private final int[] p;
    private final int[] rank;

    public TreeUnionFindSet(int n) {
        p = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            rank[i] = i;
        }
    }

    public void union(int i, int j) {
        if (find(i, j)) {
            return;
        }
        if (rank[i] > rank[j]) {
            p[j] = i;
        } else if (rank[i] < rank[j]) {
            p[i] = j;
        } else {
            p[i] = j;
            rank[j]++;
        }
    }

    public boolean find(int i, int j) {
        return findR(i) == findR(j);
    }

    private int findR(int i) {
        // 路径压缩
        if (p[i] != i) p[i] = findR(p[i]);
        return p[i];
    }
}
