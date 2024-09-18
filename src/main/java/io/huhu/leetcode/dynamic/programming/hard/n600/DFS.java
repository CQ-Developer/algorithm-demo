package io.huhu.leetcode.dynamic.programming.hard.n600;

class DFS implements Solution {

    @Override
    public int findIntegers(int n) {
        return f(n, createTable(), 30);
    }

    private int[] createTable() {
        int[] table = new int[31];
        table[0] = 1;
        table[1] = 2;
        for (int i = 2; i < 31; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table;
    }

    private int f(int num, int[] table, int i) {
        if (i == -1) {
            return 1;
        }
        int ans = 0;
        if ((num & (1 << i)) != 0) {
            ans += table[i];
            if ((num & (1 << i + 1)) != 0) {
                return ans;
            }
        }
        return ans + f(num, table, i - 1);
    }

}
