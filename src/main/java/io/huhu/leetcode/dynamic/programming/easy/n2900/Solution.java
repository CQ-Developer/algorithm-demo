package io.huhu.leetcode.dynamic.programming.easy.n2900;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-i/description/">最长相邻不相等子序列I</a>
 */
class Solution {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || groups[i] != groups[i + 1]) {
                res.add(words[i]);
            }
        }
        return res;
    }

}
