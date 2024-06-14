package io.huhu.huawei.od.s200.n15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Solution {

    // 马所有可能的移动方式
    private final static int[][] MOVE = new int[8][2];

    static {
        MOVE[0][0] = 1;
        MOVE[0][1] = 2;
        MOVE[1][0] = 1;
        MOVE[1][1] = -2;
        MOVE[2][0] = 2;
        MOVE[2][1] = 1;
        MOVE[3][0] = 2;
        MOVE[3][1] = -1;
        MOVE[4][0] = -1;
        MOVE[4][1] = 2;
        MOVE[5][0] = -1;
        MOVE[5][1] = -2;
        MOVE[6][0] = -2;
        MOVE[6][1] = 1;
        MOVE[7][0] = -2;
        MOVE[7][1] = -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();

        // 记录总共有几匹马
        int count = 0;

        // 记录所有马以及它们能走到的位置
        List<Horse> horses = new ArrayList<>();

        // 记录所有位置上, 被马走到过的次数
        // 如果当前位置上被马走到过的次数等于马的总量, 那么当前位置可以被所有马走到
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String s = scanner.next();
                if (".".equals(s)) {
                    continue;
                }
                Horse root = new Horse(i, j, 0);
                horses.addLast(root);
                count++;
                // 使用bfs构建马位置的多叉树结构
                goHorse(root, Integer.parseInt(s), m, n, grid);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到一个所有马都能到达的位置
                if (grid[i][j] == count) {
                    int step = 0;
                    for (Horse horse : horses) {
                        // 使用bfs搜索当前马到达该位置最少需要几步
                        int x = horse.findStep(i, j);
                        if (x == -1) {
                            throw new IllegalStateException("horse position error, check method goHorse().");
                        }
                        step += x;
                    }
                    res = Math.min(res, step);
                }
            }
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    /**
     * bfs
     */
    private static void goHorse(Horse root, int k, int m, int n, int[][] grid) {
        // 去重
        Set<Horse> check = new HashSet<>();
        check.add(root);
        // bfs
        List<Horse> queue = new ArrayList<>();
        queue.addLast(root);
        // 可以走k步
        while (k > 0) {
            // 使用size遍历当前层, 注意horse是一颗多叉树
            int s = queue.size();
            while (s > 0) {
                Horse cur = queue.removeFirst();
                grid[cur.i][cur.j]++;
                for (int[] move : MOVE) {
                    // 能走到的下一步位置
                    int x = cur.i + move[0], y = cur.j + move[1];
                    // 是否越界
                    if (x < 0 || x >= m) {
                        continue;
                    }
                    // 是否越界
                    if (y < 0 || y >= n) {
                        continue;
                    }
                    Horse next = new Horse(x, y, cur.step + 1);
                    // 是否已走过
                    if (check.add(next)) {
                        cur.next.addLast(next);
                        queue.addLast(next);
                    }
                }
                s--;
            }
            k--;
        }
    }

    /**
     * 马所有可能出现的位置 - 多叉树
     */
    static class Horse {

        // 马能走到的位置
        final int i;
        final int j;
        // 到当前位置需要走走几步
        final int step;
        // 下一步可以走到的位置
        final List<Horse> next = new ArrayList<>();

        Horse(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }

        /**
         * bfs
         */
        int findStep(int i, int j) {
            List<Horse> queue = new ArrayList<>();
            queue.addLast(this);
            while (!queue.isEmpty()) {
                Horse cur = queue.removeFirst();
                if (cur.i == i && cur.j == j) {
                    return cur.step;
                }
                for (Horse next : cur.next) {
                    queue.addLast(next);
                }
            }
            // 无法走到该位置
            return -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Horse horse = (Horse) o;
            return i == horse.i && j == horse.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

    }

}
