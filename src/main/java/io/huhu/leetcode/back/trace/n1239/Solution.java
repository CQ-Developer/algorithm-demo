package io.huhu.leetcode.back.trace.n1239;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/">1239.串联字符串的最大长度</a>
 * <p>给定一个字符串数组arr, 字符串s是将arr的含有不同字母的子序列字符串连接所得的字符串.
 * <p>请返回所有可行解s中最长长度.
 * <p>子序列是一种可以从另一个数组派生而来的数组, 通过删除某些元素或不删除元素而不改变其余元素的顺序.
 */
class Solution {

    /**
     * 1 <= arr.length <= 16
     * 1 <= arr[i].length <= 26
     * arr[i]中只含有小写英文字母
     */
    public int maxLength(List<String> arr) {
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, dfs(arr, new boolean[arr.size()], new StringBuilder(), 0, i + 1));
        }
        return max;
    }

    private int dfs(List<String> arr, boolean[] used, StringBuilder path, int j, int n) {
        if (j == n) {
            return path.length();
        }
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            if (used[i] || check(s)) {
                continue;
            }
            if (j > 0 && check(s + path.toString())) {
                continue;
            }
            int f = path.length();
            path.append(s);
            used[i] = true;
            max = Math.max(max, dfs(arr, used, path, j + 1, n));
            path.delete(f, path.length());
            used[i] = false;
        }
        return max;
    }

    private boolean check(String s) {
        if (s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (-1 != s.indexOf(s.codePointAt(i), i + 1)) {
                return true;
            }
        }
        return false;
    }

}
