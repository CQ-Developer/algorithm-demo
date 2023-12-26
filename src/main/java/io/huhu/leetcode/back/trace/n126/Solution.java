package io.huhu.leetcode.back.trace.n126;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.add(beginWord);
        Map<String, Set<String>> graph = new HashMap<>();
        for (String a : dict) {
            Set<String> path = new HashSet<>();
            for (String b : dict) {
                if (a.equals(b)) {
                    continue;
                }
                if (!check(a, b)) {
                    continue;
                }
                path.add(b);
            }
            graph.put(a, path);
        }
        Deque<String> path = new ArrayDeque<>();
        path.add(endWord);
        dfs(graph, beginWord, endWord, new HashSet<>(), path, res);
        return res;
    }

    private void dfs(Map<String, Set<String>> graph, String beginWord, String endWord, Set<String> used, Deque<String> path, List<List<String>> res) {
        if (endWord.equals(beginWord)) {
            if (path.size() < min) {
                res.clear();
                min = path.size();
            }
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() >= min) {
            return;
        }
        for (String word : graph.get(endWord)) {
            if (used.add(word)) {
                path.offerFirst(word);
                dfs(graph, beginWord, word, used, path, res);
                path.pollFirst();
                used.remove(word);
            }
        }
    }

    private boolean check(String a, String b) {
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                sum++;
            }
        }
        return sum == 1;
    }

}
