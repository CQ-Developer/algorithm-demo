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
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(start);
        boolean[] used = new boolean[1 << n];
        used[start] = true;
        dfs(n, used, res);
        return res;
    }

    /**
     * 核心思想：每次改变1位二进制位
     * 深度优先遍历
     */
    private boolean dfs(int n, boolean[] used, List<Integer> res) {
        if (res.size() == used.length) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            int num = res.get(res.size() - 1) ^ (1 << i);
            if (used[num]) {
                continue;
            }
            res.add(num);
            used[num] = true;
            if (dfs(n, used, res)) {
                return true;
            }
        }
        return false;
    }

}
