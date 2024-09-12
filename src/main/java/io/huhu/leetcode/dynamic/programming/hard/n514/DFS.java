package io.huhu.leetcode.dynamic.programming.hard.n514;

class DFS implements Solution {

    @Override
    public int findRotateSteps(String ring, String key) {
        int[] size = new int[26];
        int[][] where = new int[26][100];
        for (int i = 0; i < ring.length(); i++) {
            int j = ring.charAt(i) - 'a';
            where[j][size[j]++] = i;
        }
        return f(ring.toCharArray(), key.toCharArray(), where, size, 0, 0);
    }

    private int f(char[] ring, char[] key, int[][] where, int[] size, int i, int j) {
        if (j == key.length) {
            return 0;
        }
        if (ring[i] == key[j]) {
            return 1 + f(ring, key, where, size, i, j + 1);
        }
        int i1 = findClockwisely(where, size, i, key[j] - 'a');
        int c1 = i1 > i ? i1 - i : i1 - i + ring.length;
        int i2 = findCounterclockwisely(where, size, i, key[j] - 'a');
        int c2 = i > i2 ? i - i2 : i - i2 + ring.length;
        return Math.min(c1 + f(ring, key, where, size, i1, j), c2 + f(ring, key, where, size, i2, j));
    }

    private int findClockwisely(int[][] where, int[] size, int i, int v) {
        int l = 0, r = size[v] - 1, find = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (where[v][m] > i) {
                find = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return find != -1 ? where[v][find] : where[v][0];
    }

    private int findCounterclockwisely(int[][] where, int[] size, int i, int v) {
        int l = 0, r = size[v] - 1, find = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (where[v][m] < i) {
                find = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return find != -1 ? where[v][find] : where[v][size[v] - 1];
    }

}
