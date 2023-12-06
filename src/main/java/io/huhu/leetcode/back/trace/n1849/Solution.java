package io.huhu.leetcode.back.trace.n1849;

/**
 * <a href="https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/">将字符串拆分为递减的连续值</a>
 * <p>给你一个仅由数字组成的字符串s.
 * <p>请你判断能否将s拆分成两个或者多个非空子字符串, 使字符串的数值按降序排列, 且每两个相邻子字符串的数值之差等于1.
 * <ul>
 * <li>例如, 字符串 s = "0090089" 可以拆分成 ["0090", "089"], 数值为 [90, 89].
 * 这些数值满足按降序排列, 且相邻值相差1, 这种拆分方法可行.
 * <li>另一个例子种, 字符串 s = "001" 可以拆分成 ["0", "01"], ["00", "1"], ["0", "0", "1"].
 * 然而, 所有这些拆分方法都不可行, 因为对应数值分别是 [0, 1], [0, 1], [0, 0, 1], 都不满足按降序排列的要求.
 * </ul>
 * <p>如果可以按要求拆分s, 返回true; 否则, 返回false.
 * <p>子字符串是字符串中的一个连续字符序列.
 */
class Solution {

    /**
     * 1 <= s.length <= 20
     * s仅由数字组成
     */
    public boolean splitString(String s) {
        return dfs(s.toCharArray(), 0, -1);
    }

    /**
     * 深度优先遍历 + 回溯
     */
    private boolean dfs(char[] s, int j, long pre) {
        if (j == s.length) {
            return true;
        }
        long cur = 0;
        int len = j == 0 ? s.length - 1 : s.length;
        for (int i = j; i < len; i++) {
            cur = cur * 10 + (s[i] - '0');
            if (pre != -1) {
                if (pre <= cur) {
                    return false;
                }
                if (pre - 1 != cur) {
                    continue;
                }
            }
            if (dfs(s, i + 1, cur)) {
                return true;
            }
        }
        return false;
    }

}
