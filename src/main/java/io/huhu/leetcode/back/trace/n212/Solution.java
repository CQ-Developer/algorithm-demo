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

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            boolean found = false;
            for (int i = 0; i < board.length && !found; i++) {
                for (int j = 0; j < board[i].length && !found; j++) {
                    if (chars[0] == board[i][j] && dfs(board, i, j, chars, 0)) {
                        res.add(word);
                        found = true;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int c) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word[c] != board[i][j]) {
            return false;
        }
        if (c == word.length - 1) {
            return true;
        }
        board[i][j] = '.';
        boolean res = dfs(board, i - 1, j, word, c + 1)
                   || dfs(board, i + 1, j, word, c + 1)
                   || dfs(board, i, j - 1, word, c + 1)
                   || dfs(board, i, j + 1, word, c + 1);
        board[i][j] = word[c];
        return res;
    }

}
