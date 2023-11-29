package io.huhu.leetcode.back.trace.n967;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/numbers-with-same-consecutive-differences/description/">947.连续差相同的数字</a>
 * 返回所有长度位n且满足其两个连续位上的数字之间的差的绝对值为k的非负整数.
 * 请注意, 除了数字0本身之外, 答案中每个数字都不能有前导0.
 * 例如, 01有一个前导零, 所以是无效的; 但0是有效的.
 * 你可以按任意顺序返回答案.
 */
class Solution {

    /**
     * 2 <= n <= 9
     * 0 <= k <= 9
     */
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            List<Integer> path = new ArrayList<>(n);
            path.add(i);
            dfs(n - 1, k, path, result);
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    /**
     * 回溯算法
     */
    private void dfs(int n, int k, List<Integer> path, List<Integer> result) {
        if (n == 0) {
            result.add(toInt(path));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (Math.abs(path.get(path.size() - 1) - i) != k) {
                continue;
            }
            path.add(i);
            dfs(n - 1, k, path, result);
            path.remove(path.size() - 1);
        }
    }

    private int toInt(List<Integer> path) {
        int n = path.size(), f = 1, sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += f * path.get(i);
            f *= 10;
        }
        return sum;
    }

}
