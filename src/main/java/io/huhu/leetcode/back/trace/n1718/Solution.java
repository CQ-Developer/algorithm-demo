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

    /**
     * 1 <= n <= 20
     */
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        dfs(0, new boolean[n + 1], result.clone(), result);
        return result;
    }

    /**
     * 深度优先遍历 + 回溯算法
     * 核心: 优先在高位上放能放的最大数字, 而不是优先选最大数字放在能放的最高位上
     */
    private void dfs(int i, boolean[] used, int[] path, int[] result) {
        if (i == result.length) {
            System.arraycopy(path, 0, result, 0, path.length);
            return;
        }
        // result[0] == 0 表示还没有找到结果
        for (int n = used.length - 1; n > 0 && result[0] == 0; n--) {
            if (used[n]) {
                continue;
            }
            if (n == 1) {
                used[1] = true;
                path[i] = 1;
                dfs(findNextPosition(path), used, path, result);
                used[1] = false;
                path[i] = 0;
                break;
            }
            int k = i + n;
            if (k >= path.length || path[k] != 0) {
                continue;
            }
            used[n] = true;
            path[i] = n;
            path[k] = n;
            dfs(findNextPosition(path), used, path, result);
            used[n] = false;
            path[i] = 0;
            path[k] = 0;
        }
    }

    /**
     * 找到下一个可以放置数字的最高位置
     */
    private int findNextPosition(int[] path) {
        int i = 0;
        while (i < path.length) {
            if (path[i] == 0) {
                break;
            }
            i++;
        }
        return i;
    }

}
