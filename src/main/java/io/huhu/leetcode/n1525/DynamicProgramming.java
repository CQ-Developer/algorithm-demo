package io.huhu.leetcode.n1525;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DynamicProgramming implements Code {

    @Override
    public int numSplits(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        // amount of different char from left
        int[] lefts = new int[n + 1];
        boolean[] accessed = new boolean[26];
        for (int i = 1; i <= n; i++) {
            int j = c[i - 1] - 'a';
            if (accessed[j]) {
                lefts[i] = lefts[i - 1];
            } else {
                accessed[j] = true;
                lefts[i] = lefts[i - 1] + 1;
            }
        }
        // amount of different char from right
        int[] rights = new int[n + 2];
        Arrays.fill(accessed, false);
        for (int i = n; i >= 1; i--) {
            int j = c[i - 1] - 'a';
            if (accessed[j]) {
                rights[i] = rights[i + 1];
            } else {
                accessed[j] = true;
                rights[i] = rights[i + 1] + 1;
            }
        }
        // dp
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (lefts[i] == rights[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

}
