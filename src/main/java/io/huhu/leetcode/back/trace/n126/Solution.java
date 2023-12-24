package io.huhu.leetcode.back.trace.n126;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-ladder-ii/description/">单词接龙II</a>
 * <p>按字典wordList完成从单词beginWord到单词endWord转化,
 * 一个表示此过程的转换序列是形式上像 beginWord -> s<sub>1</sub> ->
 * s<sub>2</sub> ->. .. -> s<sub>k</sub> 这样的单词序列, 并满足:
 * <ul>
 * <li>每对相邻的单词之间仅有单个字母不同
 * <li>转换过程中的每个单词 s<sub>i</sub> (1 <= i <= k)必须是字典wordList中的单词.
 * 注意, beginWord不必是字典wordList中的单词
 * <li>s<sub>k</sub> == endWord
 * </ul>
 * <p>给你两个单词beginWord和endWord, 以及一个字典wordList.
 * 请你找出并返回所有从beginWord到endWord的最短转换序列, 如果不存在这样的转换序列, 返回一个空列表.
 * 每个序列都应该以单词列表 [beginWord, s<sub>1</sub>, s<sub>2</sub>,
 * ..., s<sub>k</sub>] 的形式返回.
 * <p>提示:
 * <ul>
 * <li>1 <= beginWord.length <= 5
 * <li>endWord.length == beginWord.length
 * <li>1 <= wordList.length <= 500
 * <li>wordList[i].length == beginWord.length
 * <li>beginWord、endWord和wordList[i]由小写英文字母组成
 * <li>beginWord != endWord
 * <li>wordList中所有单词互不相同
 * </ul>
 */
class Solution {

    private int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 将字符串列表抓换成图
        wordList.add(0, beginWord);
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Boolean> index = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            index.put(wordList.get(i), false);
            if (endWord.equals(wordList.get(i))) {
                continue;
            }
            List<String> list = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (!check(wordList.get(i), wordList.get(j))) {
                    continue;
                }
                list.add(wordList.get(j));
            }
            map.put(wordList.get(i), list);
        }
        index.put(beginWord, true);
        // 回溯
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        List<List<String>> res = new ArrayList<>();
        backTracing(map, index, beginWord, endWord, path, res);
        return res;
    }

    private void backTracing(Map<String, List<String>> map, Map<String, Boolean> used, String beginWord, String endWord, Deque<String> path, List<List<String>> res) {
        if (path.size() > min) {
            return;
        }
        if (beginWord.equals(endWord)) {
            if (path.size() < min) {
                min = path.size();
                res.clear();
            }
            res.add(new ArrayList<>(path));
            return;
        }
        for (String nextWord : map.get(beginWord)) {
            if (used.get(nextWord)) {
                continue;
            }
            used.put(nextWord, true);
            path.addLast(nextWord);
            backTracing(map, used, nextWord, endWord, path, res);
            used.put(nextWord, false);
            path.removeLast();
        }
    }

    private boolean check(String a, String b) {
        int n = a.length(), d = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                d++;
            }
        }
        return d == 1;
    }

}
