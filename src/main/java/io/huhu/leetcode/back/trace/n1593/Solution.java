package io.huhu.leetcode.back.trace.n1593;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/description/">1593.拆分字符串使唯一子字符串的数目最大</a>
 * <p>给你一个字符串s, 请你拆分该字符串, 并返回拆分后唯一字符串的最大数目.
 * <p>字符串s拆分后可以得到若干非空字符串, 这些子字符串连接后应当能够还原为原字符串.
 * 但使拆分出来的每个子字符串都必须使唯一的.
 * <p>注意: 子字符串是字符串中的一个连续字符串序列.
 */
class Solution {

    /**
     * 1 <= s.length <= 16
     * s仅包含小写英文字母
     */
    public int maxUniqueSplit(String s) {
        return dfs(s, 0, new HashSet<>());
    }

    /**
     * 深度优先遍历
     */
    private int dfs(String s, int j, Set<String> path) {
        if (j == s.length()) {
            return path.size();
        }
        int max = 0;
        for (int i = j; i < s.length(); i++) {
            String sub = s.substring(j, i + 1);
            if (path.add(sub)) {
                max = Math.max(max, dfs(s, i + 1, path));
                path.remove(sub);
            }
        }
        return max;
    }

}
