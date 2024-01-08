package io.huhu.leetcode.back.trace.n1238;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/circular-permutation-in-binary-representation/description/">1238.循环码排列</a>
 * <p>给你两个整数n和start.
 * 你的任务是返回任意(0,1,2,...,2^n-1)的排列p, 并且满足:
 * <ul>
 * <li>p[0] = start
 * <li>p[i]和p[i+1]的二进制表示形式只有一位不同
 * <li>p[0]和p[2^n-1]的二进制表示形式也只有一位不同
 * </ul>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= n <= 16</li>
     * <li>0 <= start < 2^n</li>
     * </ul>
     */
    public List<Integer> circularPermutation(int n, int start) {
        int[] table = new int[1 << n];
        for (int i = 0; i < n; i++) {
            table[1 << i] = 1;
        }
        List<Integer> res = new ArrayList<>(1 << n);
        int[] path = new int[1 << n];
        path[0] = start;
        boolean[] used = new boolean[1 << n];
        used[start] = true;
        dfs(table, used, 1, path, res);
        return res;
    }

    private void dfs(int[] table, boolean[] used, int j, int[] path, List<Integer> res) {
        if (j == path.length) {
            if (table[path[0] ^ path[j - 1]] == 1) {
                for (int n : path) {
                    res.add(n);
                }
            }
            return;
        }
        for (int i = used.length - 1; i >= 0 && res.isEmpty(); i--) {
            if (used[i] || table[i ^ path[j - 1]] == 0) {
                continue;
            }
            used[i] = true;
            path[j] = i;
            dfs(table, used, j + 1, path, res);
            used[i] = false;
        }
    }

}
