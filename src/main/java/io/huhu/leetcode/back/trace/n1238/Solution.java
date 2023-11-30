package io.huhu.leetcode.back.trace.n1238;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
     * 1 <= n <= 16
     * 0 <= start < 2^n
     */
    public List<Integer> circularPermutation(int n, int start) {
        int len = 1 << n;
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[len];
        used[start] = true;
        Deque<Integer> path = new ArrayDeque<>();
        path.add(start);
        dfs(used, path, result);
        return result;
    }

    /**
     * 深度优先遍历 + 回溯
     */
    private void dfs(boolean[] used, Deque<Integer> path, List<Integer> result) {
        if (path.size() == used.length) {
            result.addAll(path);
            return;
        }
        for (int i = 0; i < used.length && result.isEmpty(); i++) {
            if (used[i]) {
                continue;
            }
            if (check(i ^ path.getLast())) {
                continue;
            }
            if (path.size() == used.length - 1 && check(i ^ path.getFirst())) {
                continue;
            }
            used[i] = true;
            path.addLast(i);
            dfs(used, path, result);
            used[i] = false;
            path.removeLast();
        }
    }

    /**
     * 统计二进制位1的个数
     */
    private boolean check(int i) {
        int cnt = 0;
        while (i != 0) {
            i &= (i - 1);
            if (++cnt > 1) {
                return true;
            }
        }
        return false;
    }

}
