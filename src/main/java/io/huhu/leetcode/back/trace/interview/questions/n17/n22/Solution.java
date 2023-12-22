package io.huhu.leetcode.back.trace.interview.questions.n17.n22;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-transformer-lcci/description/">单词转换</a>
 * <p>给定字典中的两个词, 长度相等. 写一个方法, 把一个词转换成另一个词, 但是一次只能改变一个字符.
 * 每一步得到的新词都必须能在字典中找到.
 * <p>编写一个程序, 返回一个可能的转换序列. 如有多个可能的转换序列, 你可以返回任何一个.
 */
class Solution {

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        if (backTracing(wordList, new boolean[wordList.size()], beginWord, endWord, res)) {
            res.add(0, beginWord);
        }
        return res;
    }

    private boolean backTracing(List<String> wordList, boolean[] used, String beginWord, String endWord, List<String> res) {
        if (beginWord.equals(endWord)) {
            return true;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (used[i]) {
                continue;
            }
            if (!check(beginWord, wordList.get(i))) {
                continue;
            }
            used[i] = true;
            res.add(wordList.get(i));
            if (backTracing(wordList, used, wordList.get(i), endWord, res)) {
                return true;
            }
            used[i] = false;
            res.remove(res.size() - 1);
        }
        return false;
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sum++;
            }
        }
        return sum == 1;
    }

}
