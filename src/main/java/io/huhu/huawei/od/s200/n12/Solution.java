package io.huhu.huawei.od.s200.n12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135139306">找城市/城市聚集度</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input
        int n = scanner.nextInt();
        int[][] nodes = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            nodes[i][0] = scanner.nextInt();
            nodes[i][1] = scanner.nextInt();
        }
        // alg
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 使用并查集对城市群进行分类
            UF uf = new UF(n);
            for (int[] node : nodes) {
                // 假设当前切断到达城市i的通路
                if (node[0] == i || node[1] == i) {
                    continue;
                }
                uf.union(node[0], node[1]);
            }
            // 找出城市集群的最大值
            int max = uf.max(i);
            if (result.isEmpty()) {
                result.addLast(max);
            } else {
                int num = result.getLast();
                if (max == num) {
                    result.addLast(max);
                }
                if (max < num) {
                    result.clear();
                    result.addLast(max);
                }
            }
        }
        // output
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    /**
     * 并查集
     */
    static class UF {

        // 并查集
        final int[] uf;

        // 集的节点数量
        final int[] cnt;

        /**
         * 初始化
         */
        UF(int n) {
            uf = new int[n + 1];
            cnt = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                uf[i] = i;
                cnt[i] = 1;
            }
        }

        /**
         * 查找
         */
        int find(int i) {
            if (i == uf[i]) {
                return i;
            }
            // 路径压缩
            return uf[i] = find(uf[i]);
        }

        /**
         * 合并
         */
        void union(int i, int j) {
            int x = find(i), y = find(j);
            int a = Math.min(x, y), b = Math.max(x, y);
            uf[b] = a;
            cnt[a] += cnt[b];
        }

        /**
         * 找出最大的节点数
         */
        int max(int n) {
            int max = 0;
            for (int i = 1; i < cnt.length; i++) {
                if (i != n && cnt[i] > max) {
                    max = cnt[i];
                }
            }
            return max;
        }

    }

}
