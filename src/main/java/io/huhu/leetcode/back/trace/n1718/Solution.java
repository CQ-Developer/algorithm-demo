package io.huhu.leetcode.back.trace.n1718;

/**
 * <a href="https://leetcode.cn/problems/construct-the-lexicographically-largest-valid-sequence/description/">1718.构建字典序最大的可行序列</a>
 * <p>给你一个整数n, 请你找到满足下面条件的一个序列:
 * <ul>
 * <li>整数1在序列中只出现一次
 * <li>2到n之间每个整数都恰好出现两次
 * <li>对于每个2到n之间的整数i, 两个i之间出现的距离恰好为i
 * </ul>
 * <p>序列里面两个数a[i]和a[j]之间的距离, 我们定义为它们下标绝对值之差[j - i]
 * <p>请你返回满足上述条件中字典序最大的序列. 题目保证在给定限制条件下, 一定存在解.
 * <p>一个序列a被认为比序列b字典(两者长度相同)序更大的条件是: a和b中第一个不一样的数字处,
 * a序列的数字比b序列的数字大. 比方说, [0,1,9,0]比[0,1,5,6]字典序更大,
 * 因为第一个不同的位置是第三个数字, 且9比5大.
 */
class Solution {

    private int[] result;

    private boolean[] used;

    /**
     * 1 <= n <= 20
     */
    public int[] constructDistancedSequence(int n) {
        this.result = new int[2 * n - 1];
        this.used = new boolean[n + 1];
        dfs(0);
        return result;
    }

    /**
     * 深度优先遍历 + 回溯算法
     * 核心: 优先在高位上放能放的最大数字, 而不是优先选最大数字放在能放的最高位上
     */
    private boolean dfs(int p) {
        if (p >= result.length) {
            return true;
        }
        if (result[p] != 0) {
            return dfs(p + 1);
        }
        for (int i = used.length - 1; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1) {
                used[1] = true;
                result[p] = 1;
                if (dfs(p + 1)) {
                    return true;
                }
                used[1] = false;
                result[p] = 0;
                return false;
            } else {
                if (p + i >= result.length) {
                    continue;
                }
                if (result[p + i] != 0) {
                    continue;
                }
                result[p] = i;
                result[p + i] = i;
                used[i] = true;
                if (dfs(p + 1)) {
                    return true;
                }
                result[p] = 0;
                result[p + i] = 0;
                used[i] = false;
            }
        }
        return false;
    }

}
