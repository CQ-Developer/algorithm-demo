package io.huhu.leetcode.back.trace.n842;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-array-into-fibonacci-sequence/description/">842.将数组拆分成斐波那契序列</a>
 * 给定一个数字字符串num, 比如"123456579", 我们可以将它分成斐波那契式的序列[123, 456, 579].
 * 形式上, 斐波那契序列是一个非负整数列表f, 且满足:
 * 0 <= f[i] < 2^31, 也就是说每个整数都符合32位有符号整数类型
 * f.length >= 3
 * 对于所有的 0 <= i < f.length - 2, 都有 f[i] + f[i + 1] = f[i + 2]
 * 另外, 请注意, 将字符串拆分成小块时, 每个块的数字一定不要以零开头, 除非这个块是数字0本身.
 * 返回从num拆分出来的任意一组斐波那契式的序列块, 如果不能拆分则返回[].
 */
class Solution {

    /**
     * 1 <= num.length <= 200
     * num中只含有数字
     */
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        dfs(num, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void dfs(String str, int j, List<Integer> path, List<Integer> result) {
        if (j == str.length() && path.size() >= 3) {
            result.addAll(new ArrayList<>(path));
            return;
        }
        for (int i = j; i < str.length() && result.isEmpty(); i++) {
            // 斐波那契数列最少需要3个元素
            if (path.size() < 2 && str.length() - i - path.size() == 0) {
                break;
            }
            boolean is0 = str.charAt(j) == '0';
            // 当前是0就不能进行下一轮循环了
            if (is0 && i > j) {
                break;
            }
            int num = is0 ? str.charAt(i) - '0' : toInt(str.substring(j, i + 1));
            // 整数越界问题
            if (num == -1) {
                break;
            }
            // 判断是否为斐波那契数列
            if (path.size() >= 2) {
                int sum = path.get(path.size() - 2) + path.get(path.size() - 1);
                if (num < sum) {
                    continue;
                }
                if (num > sum) {
                    break;
                }
            }
            // 回溯
            path.add(num);
            dfs(str, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 将字符串转为数字
     */
    private int toInt(String num) {
        // 越界问题
        if (num.length() > 10 || num.length() == 10 && num.compareTo("2147483647") > 0) {
            return -1;
        }
        int n = num.length(), f = 1, sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += f * (num.charAt(i) - '0');
            f *= 10;
        }
        return sum;
    }

}
