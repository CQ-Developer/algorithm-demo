package io.huhu.leetcode.back.trace.n79;

/**
 * <h1><a href="https://leetcode.cn/problems/word-search/description/">79.单词搜索</a></h1>
 * 给定一个m*n二维字符网格board和一个字符串单词word. 如果word存在于网格中, 返回true; 否则, 返回false.
 * 单词必须按照字母顺序, 通过相邻的单元格的内的字母构成, 其中"相邻"单元格是那些水平相邻或垂直相邻的单元格.
 * 同一个单元格内的字母不允许被重复使用.
 * 进阶: 你可以使用搜索剪枝的技术来优化解决方案, 使其在board更大的情况下可以更快解决问题?
 */
class Solution {

    /**
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backTrace(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrace(char[][] board, int i, int j, String word, int c) {
        // todo
        return false;
    }

}
