package io.huhu.leetcode.back.trace.n126;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        boolean found = bfs(beginWord, endWord, steps, graph, dict);
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backtrack(graph, path, beginWord, endWord, res);
        }
        return res;
    }

    private boolean bfs(String beginWord, String endWord, Map<String, Integer> steps, Map<String, List<String>> graph, Set<String> dict) {
        int step = 1;
        boolean found = false;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                String currentWord = queue.remove();
                char[] chars = currentWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = String.valueOf(chars);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            graph.get(nextWord).add(currentWord);
                        }
                        if (queue.isEmpty() && dict.isEmpty()) {
                            break;
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        dict.remove(nextWord);
                        queue.add(nextWord);
                        graph.putIfAbsent(nextWord, new ArrayList<>());
                        graph.get(nextWord).add(currentWord);
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    chars[i] = origin;
                }
            }
            step++;
            if (found) {
                break;
            }
        }
        return found;
    }

    public void backtrack(Map<String, List<String>> from, Deque<String> path, String beginWord, String currentWord, List<List<String>> res) {
        if (currentWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(currentWord)) {
            path.addFirst(precursor);
            backtrack(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }

}
