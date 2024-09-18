package io.huhu.leetcode.dynamic.programming.hard.n600;

class DP implements Solution {

    @Override
    public int findIntegers(int n) {
        int[] table = createTable();
        int ans = 0;
        for (int i = 30; i >= -1; i--) {
            if (i == -1) {
                ans++;
                break;
            }
            if ((n & (1 << i)) != 0) {
                ans += table[i];
                if ((n & (1 << i + 1)) != 0) {
                    break;
                }
            }
        }
        return ans;
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

}
