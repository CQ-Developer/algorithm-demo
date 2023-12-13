package io.huhu.leetcode.back.trace.n2305;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/fair-distribution-of-cookies/description/">公平分发饼干</a>
 * <p>给你一个整数数组cookies, 其中cookies[i]表示在第i个零食包中的饼干数量.
 * 另给你一个整数k表示等待分发零食包的孩子数量, 所有零食包都需要分发.
 * 在同一个零食包中的所有饼干必须分发给同一个孩子, 不能分开.
 * <p>分发的不公平程度定义为单个孩子在分发过程中能够获得饼干的最大总数.
 * <p>返回所有分发的最小不公平程度.
 */
class Solution {

    private int res = Integer.MAX_VALUE;

    /**
     * 提示:
     * <ul>
     * <li>2 <= cookies.length <= 8
     * <li>1 <= cookies[i] <= 10<sup>5</sup>
     * <li>2 <= k <= cookies.length
     * </ul>
     */
    public int distributeCookies(int[] cookies, int k) {
        sort(cookies);
        dfs(cookies, 0, new boolean[cookies.length], new int[k], k);
        return res;
    }

    private void dfs(int[] cookies, int cnt, boolean[] used, int[] path, int k) {
        if (cnt == cookies.length) {
            int max = findMax(path, k);
            res = Integer.min(max, res);
            return;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (used[i]) {
                continue;
            }
            int p = findMin(path, k);
            used[i] = true;
            path[p] += cookies[i];
            if (path[p] < res) {
                dfs(cookies, cnt + 1, used, path, k);
            }
            used[i] = false;
            path[p] -= cookies[i];
        }
    }

    private int findMin(int[] path, int k) {
        int i = 0;
        for (int j = 1; j < k; j++) {
            if (path[i] > path[j]) {
                i = j;
            }
        }
        return i;
    }

    private int findMax(int[] path, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (path[i] > max) {
                max = path[i];
            }
        }
        return max;
    }

    private void sort(int[] cookies) {
        Arrays.sort(cookies);
        int l = 0, r = cookies.length - 1;
        while (l < r) {
            int t = cookies[l];
            cookies[l++] = cookies[r];
            cookies[r--] = t;
        }
    }

}
