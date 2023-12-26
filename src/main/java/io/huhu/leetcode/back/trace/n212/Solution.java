package io.huhu.leetcode.back.trace.n212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int max = 0;
        Set<String> dict = new HashSet<>();
        Set<Character> startChar = new HashSet<>();
        for (String word : words) {
            dict.add(word);
            startChar.add(word.charAt(0));
            max = Math.max(max, word.length());
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length && !dict.isEmpty(); i++) {
            for (int j = 0; j < board[i].length && !dict.isEmpty(); j++) {
                if (startChar.contains(board[i][j])) {
                    dfs(board, i, j, dict, new StringBuilder(), max, res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, Set<String> words, StringBuilder sb, int max, List<String> res) {
        String word = sb.toString();
        if (words.contains(word)) {
            words.remove(word);
            res.add(word);
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '.') {
            return;
        }
        if (words.isEmpty() || sb.length() > max) {
            return;
        }
        char c = board[i][j];
        board[i][j] = '.';
        sb.append(c);
        dfs(board, i + 1, j, words, sb, max, res);
        dfs(board, i - 1, j, words, sb, max, res);
        dfs(board, i, j - 1, words, sb, max, res);
        dfs(board, i, j + 1, words, sb, max, res);
        board[i][j] = c;
        sb.deleteCharAt(sb.length() - 1);
    }

}
