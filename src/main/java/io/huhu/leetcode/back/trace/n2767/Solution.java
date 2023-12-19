package io.huhu.leetcode.back.trace.n2767;

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
 */
class Solution {

    private final String[] arr = {"11110100001001", "110000110101", "1001110001", "1111101", "11001", "101", "1"};

    private int res = -1;

    /**
     * 提示:
     * <ul>
     * <li>1 <= s.length <= 15
     * <li>s[i]要么是'0'要么是'1'
     * </ul>
     */
    public int minimumBeautifulSubstrings(String s) {
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i].length() <= s.length()) {
                break;
            }
        }
        dfs(i, arr, s, "", 0);
        return res;
    }

    /**
     * 回溯算法
     */
    private void dfs(int i, String[] arr, String s, String path, int cnt) {
        if (s.equals(path)) {
            res = cnt;
            return;
        }
        for (int j = i; j < arr.length && path.length() < s.length() && res == -1; j++) {
            dfs(i, arr, s, path + arr[j], cnt + 1);
        }
    }

}
