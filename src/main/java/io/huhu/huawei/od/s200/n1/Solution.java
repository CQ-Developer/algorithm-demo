package io.huhu.huawei.od.s200.n1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 5G网络建设
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] graph = new int[M][4];
        for (int i = 0; i < M; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int Z = scanner.nextInt();
            int P = scanner.nextInt();
            graph[i][0] = X;
            graph[i][1] = Y;
            graph[i][2] = Z;
            graph[i][3] = P;
        }
        int res = new Solution().build5GNetwork(N, M, graph);
        System.out.println(res);
    }

    /**
     * entry point
     */
    public int build5GNetwork(int n, int m, int[][] graph) {
        // 初始化并查集
        // 并查集的作用是: 查找元素所属集合, 合并元素所属集合
        // https://oi-wiki.org/ds/dsu/
        int[] parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        // 遍历所有的边并将已存在光纤的边合并
        for (int[] g : graph) {
            // 已存在连接则直接合并
            if (g[3] == 1) {
                union(parent, g[0], g[1]);
            }
        }
        // 按照成本从小到大排序
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));
        // 总成本
        int cost = 0;
        for (int[] g : graph) {
            if (find(parent, g[0]) != find(parent, g[1])) {
                cost += g[2];
                union(parent, g[0], g[1]);
            }
        }
        // 检查所有基站是否在同一集合中
        // 若基站中存在不在同一集合的节点, 则表示存在不能连通的节点则返回-1
        for (int i = 2; i < parent.length; i++) {
            if (find(parent, i) != find(parent, 1)) {
                return -1;
            }
        }
        return cost;
    }

    /**
     * 并查集合并
     */
    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }

    /**
     * 并查集查找
     */
    private int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

}
