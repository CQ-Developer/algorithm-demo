package io.huhu.leetcode.back.trace.interview.questions.n16.n18;

/**
 * <a href="https://leetcode.cn/problems/pattern-matching-lcci/description/">模式匹配</a>
 * <p>你有两个字符串, 即pattern和value. pattern字符串由字母"a"和"b"组成, 用于描述字符串中的模式.
 * 例如, 字符串"catcatgocatgo"匹配模式"aabab"(其中"cat"是"a", "go"是"b"), 该字符串也匹配像"a"、"ab"和"b"这样的模式.
 * 但需注意"a"和"b"不能同时表示相同的字符串. 编写一个方法判断value字符串是否匹配pattern字符串.
 * <p>提示:
 * <li>1 <= len(pattern) <= 1000
 * <li>0 <= len(value) <= 1000
 * <li>你可以假设pattern只包含字母"a"和"b", value仅包含小写字母
 */
class Solution {

    public boolean patternMatching(String pattern, String value) {
        return backTracing(pattern.toCharArray(), 0, value, 0, new String[2]);
    }

    private boolean backTracing(char[] pattern, int i, String value, int j, String[] path) {
        if (i == pattern.length) {
            return j == value.length();
        }
        int x = pattern[i] - 'a';
        if (path[x] != null) {
            return value.startsWith(path[x], j) && backTracing(pattern, i + 1, value, j + path[x].length(), path);
        }
        for (int k = j; k <= value.length(); k++) {
            path[x] = value.substring(j, k);
            if (!path[x].equals(path[x ^ 1]) && backTracing(pattern, i + 1, value, k, path)) {
                return true;
            }
            path[x] = null;
        }
        return false;
    }

}
