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
        dfs(n, result.clone(), result);
        return result;
    }

    private void dfs(int n, int[] path, int[] result) {
        if (n == 0 && isGreater(path, result)) {
            System.arraycopy(path, 0, result, 0, path.length);
            return;
        }
        for (int i = 0; i < path.length && n > 0; i++) {
            if (path[i] != 0) {
                continue;
            }
            if (n == 1) {
                path[i] = n;
                dfs(0, path, result);
                path[i] = 0;
                break;
            }
            int j = i + n < path.length ? i + n : -1;
            if (j != -1 && path[j] == 0) {
                path[i] = n;
                path[j] = n;
                dfs(n - 1, path, result);
                path[j] = 0;
                path[i] = 0;
            }
        }
    }

    private boolean isGreater(int[] path, int[] result) {
        for (int i = 0; i < result.length; i++) {
            if (path[i] > result[i]) {
                return true;
            }
            if (path[i] < result[i]) {
                break;
            }
        }
        return false;
    }

}
