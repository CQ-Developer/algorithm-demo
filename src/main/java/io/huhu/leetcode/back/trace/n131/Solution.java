package io.huhu.leetcode.back.trace.n131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">131.分割回文串</a>
 * 给你一个字符串s, 请你将s分割成一些子串, 使每个子串都是回文串.
 * 返回s所有可能的分割方案.
 * 回文串是正着读和反着读都一样的字符串.
 */
class Solution {

    /**
     * 1 <= s.length <= 16
     * s仅由小写英文字母组成
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrace(s.toCharArray(), 0, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(char[] chars, int i, Deque<String> path, List<List<String>> result) {
        if (i == chars.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            if (isMatch(chars, i, j)) {
                path.addLast(new String(chars, i, j - i + 1));
                backTrace(chars, j + 1, path, result);
                path.removeLast();
            }
        }
    }

    /**
     * 判断是否为回文字符串
     */
    private boolean isMatch(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }

}
