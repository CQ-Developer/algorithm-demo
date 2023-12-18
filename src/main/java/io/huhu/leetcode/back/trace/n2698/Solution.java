package io.huhu.leetcode.back.trace.n2698;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/">求一个整数的惩罚数</a>
 * <p>n的惩罚数定义为所有满足以下条件i的数的平方和:
 * <ul>
 * <li>1 <= i <= n
 * <li>i * i 的十进制表示的字符串可以分割成若干连续子字符串, 且这些子字符串对应的整数值之和等于i
 * </ul>
 */
class Solution {

    private int res = 1;

    /**
     * 提示:
     * <ul>
     * <li>1 <= n <= 1000
     * </ul>
     */
    public int punishmentNumber(int n) {
        Set<Integer> used = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            String s = i * i + "";
            dfs(s.toCharArray(), 0, i, 0, used);
        }
        return res;
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private void dfs(char[] chars, int s, int target, int sum, Set<Integer> set) {
        if (s == chars.length && target == sum) {
            set.add(target);
            res += target * target;
            return;
        }
        int n = 0, len = s == 0 ? chars.length - 1 : chars.length;
        for (int i = s; i < len && !set.contains(target); i++) {
            n = 10 * n + (chars[i] - '0');
            dfs(chars, i + 1, target, sum + n, set);
        }
    }

}
