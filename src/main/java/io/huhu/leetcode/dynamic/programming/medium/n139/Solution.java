package io.huhu.leetcode.dynamic.programming.medium.n139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/word-break/description/">单词拆分</a>
 */
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        return backTrace(s, 0, new HashSet<>(wordDict), new boolean[s.length()]);
    }

    private boolean backTrace(String s, int i, Set<String> wordDict, boolean[] deadEnd) {
        if (i == s.length()) {
            return true;
        }
        if (deadEnd[i]) {
            return false;
        }
        for (String w : wordDict) {
            if (s.startsWith(w, i) && backTrace(s, i + w.length(), wordDict, deadEnd)) {
                return true;
            }
        }
        deadEnd[i] = true;
        return false;
    }

}
