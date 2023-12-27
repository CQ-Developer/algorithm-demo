package io.huhu.leetcode.back.trace.n212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-search-ii/description/">单词搜索II</a>
 * <p>给定一个 m x n 二维字符网格 board 和一个单词列表 words, 返回所有二维网格上的单词.
 * <p>单词必须按照字母顺序, 通过相邻的单元格内的字母构成, 其中"相邻"单个格是那些水平响铃或垂直相邻的单元格.
 * 同一个单元格内的字母在一个单词中不允许被重复使用.
 * <p>提示:
 * <ul>
 * <li>m ==board.length
 * <li>n == board[i].length
 * <li>1 <= m, n <= 12
 * <li>board[i][j] 是一个小写英文字母
 * <li>1 <= words.length <= 3 x 10<sup>10</sup>
 * <li>1 <= words[i].length <= 10
 * <li>words[i] 由小写英文字母组成
 * <li>words 中的所有字符串互不相同
 * </ul>
 */
class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
        if (!cur.children.containsKey(board[i][j])) {
            return;
        }
        char c = board[i][j];
        cur = cur.children.get(c);
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        board[i][j] = '.';
        if (i > 0) {
            dfs(board, i - 1, j, cur, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, cur, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, cur, res);
        }
        if (j < board[i].length - 1) {
            dfs(board, i, j + 1, cur, res);
        }
        board[i][j] = c;
    }

    /**
     * 前缀树/字典树
     */
    static class TrieNode {

        String word;
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
        }

        void addWord(String word) {
            TrieNode cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }

    }

}
