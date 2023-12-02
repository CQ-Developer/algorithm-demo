package io.huhu.leetcode.back.trace.n1239;

import java.util.ArrayList;
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
        boolean[] letters = new boolean[26];
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, dfs(arr, 0, letters, "", 0, i + 1));
        }
        return max;
    }

    /**
     * 回溯算法
     */
    private int dfs(List<String> arr, int j, boolean[] letters, String path, int d, int n) {
        if (d == n) {
            return path.length();
        }
        int max = 0;
        for (int i = j; i < arr.size() + d - n + 1; i++) {
            String s = arr.get(i);
            List<Integer> rcd = record(s, letters);
            if (rcd.size() == s.length()) {
                max = Math.max(max, dfs(arr, j + 1, letters, path + s, d + 1, n));
            }
            for (int r : rcd) {
                letters[r] = false;
            }
        }
        return max;
    }

    /**
     * 记录哪些字母被使用了
     */
    private List<Integer> record(String s, boolean[] letters) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (letters[j]) {
                continue;
            }
            list.add(j);
            letters[j] = true;
        }
        return list;
    }

}
