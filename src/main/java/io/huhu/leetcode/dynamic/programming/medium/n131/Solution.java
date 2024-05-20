package io.huhu.leetcode.dynamic.programming.medium.n131;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">分割回文串</a>
 */
class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrace(s.toCharArray(), 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrace(char[] s, int i, List<String> path, List<List<String>> ans) {
        if (i == s.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length; j++) {
            if (isMatch(s, i, j)) {
                path.addLast(String.valueOf(s, i, j - i + 1));
                backTrace(s, j + 1, path, ans);
                path.removeLast();
            }
        }
    }

    private boolean isMatch(char[] s, int i, int j) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

}
