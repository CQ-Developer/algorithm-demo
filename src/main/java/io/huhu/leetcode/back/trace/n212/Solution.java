package io.huhu.leetcode.back.trace.n212;

import java.util.ArrayList;
import java.util.List;

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

    private final Trie root = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            root.add(words[i], i);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, words, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, String[] words, Trie cur, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] < 'a') {
            return;
        }
        cur = cur.node[board[i][j] - 'a'];
        if (cur == null) {
            return;
        }
        if (cur.wordIndex != -1) {
            res.add(words[cur.wordIndex]);
            root.remove(words[cur.wordIndex], cur);
        }
        if (cur.wordNum == 0) {
            return;
        }
        board[i][j] -= 'a';
        dfs(board, i - 1, j, words, cur, res);
        dfs(board, i + 1, j, words, cur, res);
        dfs(board, i, j - 1, words, cur, res);
        dfs(board, i, j + 1, words, cur, res);
        board[i][j] += 'a';
    }

    /**
     * 前缀树 / 字典树
     */
    static class Trie {

        /** 子节点 */
        final Trie[] node = new Trie[26];

        /** 单词数量 */
        int wordNum;

        /** 指向单词列表的单词 */
        int wordIndex = -1;

        /**
         * 将的单词加入树
         */
        void add(String word, int index) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.node[i] == null) {
                    cur.node[i] = new Trie();
                }
                cur.wordNum++;
                cur = cur.node[i];
            }
            cur.wordIndex = index;
        }

        /**
         * 从树中删除单词
         */
        void remove(String word, Trie cur) {
            cur.wordIndex = -1;
            cur = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (--cur.wordNum == 0) {
                    cur.node[i] = null;
                    break;
                }
                cur = cur.node[i];
            }
        }

    }

}
