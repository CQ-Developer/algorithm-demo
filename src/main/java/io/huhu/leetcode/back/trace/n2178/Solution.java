package io.huhu.leetcode.back.trace.n2178;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-split-of-positive-even-integers/description/">拆分成最多数目的正偶数之和</a>
 * <p>给你一个整数finalSm. 请你将它拆分成若干个互不相同的正偶数之和, 且拆分出来的正偶数数目最多.
 * <ul>
 * <li>比方说, 给你finalSum = 12, 那么这些拆分是符合要求的: (2+10), (2+4+6)和(4+8).
 * 它们中, (2+4+6)包含最多数目的整数. 注意finalSum不能拆分成(2+2+4+4), 因为拆分出来的整数必须互不相同.
 * </ul>
 * <p>请你返回一个整数数组, 表示将整数拆分成最多数目的正偶数数组. 如果没有办法将finalSum进行拆分, 请你返回一个空数组. 你可以按任意顺序返回这些整数.
 */
class Solution {

    /**
     * 1 <= finalSum <= 10<sup>10</sup>
     */
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        dfs(2, finalSum, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(long j, long finalSum, long sum, Deque<Long> path, List<Long> res) {
        if (sum == finalSum) {
            res.addAll(new ArrayList<>(path));
            return;
        }
        for (long i = j; i + sum <= finalSum && res.isEmpty(); i += 2) {
            path.addLast(i);
            dfs(i + 2, finalSum, sum + i, path, res);
            path.removeLast();
        }
    }

}
