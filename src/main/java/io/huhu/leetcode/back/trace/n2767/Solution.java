package io.huhu.leetcode.back.trace.n2767;

import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/partition-string-into-minimum-beautiful-substrings/description/">将字符串分割为最少的美丽子字符串</a>
 * <p>给你一个二进制字符串s, 你需要将字符串分割成一个或多个子字符串, 使每个字符串都是美丽的.
 * <p>如果一个字符串满足以下条件, 我们称它是美丽的:
 * <ul>
 * <li>它不包含前导0
 * <li>它是5的幂的二进制表示
 * </ul>
 * <p>请你返回分割后的子字符串的最少数目.如果无法将字符串s分割成美丽子字符串, 请你返回-1.
 * <p>子字符串是一个字符串中一段连续的字符序列.
 * <p>提示:
 * <ul>
 * <li>1 <= s.length <= 15
 * <li>s[i]要么是'0'要么是'1'
 * </ul>
 */
class Solution {

    public int minimumBeautifulSubstrings(String s) {
        return dfs(Set.of(1, 5, 25, 125, 625, 3125, 15625), 0, s.toCharArray(), 0);
    }

    private int dfs(Set<Integer> nums, int num, char[] s, int i) {
        if (i == s.length) {
            return nums.contains(num) ? 1 : -1;
        }
        // 不能包含前导0
        if (num == 0 && s[i] == '0') {
            return -1;
        }
        // 找5的幂, 尽量找到最大的5的幂, 也就是尽量使用最深的数字
        int res = dfs(nums, 2 * num + s[i] - '0', s, i + 1);
        if (res != -1) {
            return res;
        }
        // 注意这里是在回溯的过程中
        // 在已经找到的5的幂的情况下再次寻找下一个5的幂
        if (nums.contains(num) && s[i] == '1') {
            res = dfs(nums, s[i] - '0', s, i + 1);
            if (res != -1) {
                return res + 1;
            }
        }
        return -1;
    }

}
