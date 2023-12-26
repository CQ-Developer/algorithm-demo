package io.huhu.leetcode.back.trace.n140;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-break-ii/description/">单词拆分II</a>
 * <p>给定一个字符串s和一个字符串字典wordDict, 在字符串s中增加空格来构建一个句子,
 * 使得句子中所有的单词都在词典中. 以任意顺序返回所有这些可能的句子.
 * <p>注意: 词典中的同一个单词可能在分段中被重复使用多次.
 * <p>提示:
 * <ul>
 * <li>1 <= s.length <= 20
 * <li>1 <= wordDict.length <= 1000
 * <li>1 <= wordDict[i].length <= 10
 * <li>s和wordDict[i]仅有小写英文字母组成
 * <li>wordDict中所有字符串都不同
 * </ul>
 */
class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, wordDict, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(String s, int i, List<String> dict, Deque<String> path, List<String> res) {
        if (i == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (String word : dict) {
            if (s.startsWith(word, i)) {
                path.addLast(word);
                dfs(s, i + word.length(), dict, path, res);
                path.removeLast();
            }
        }
    }

}
