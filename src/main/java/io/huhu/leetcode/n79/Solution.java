package io.huhu.leetcode.n79;

/**
 * <h1>
 * 79.单词搜索
 * </h1>
 *
 * <p>
 * 给定一个m*n二位字符网格board和一个字符串单词word。
 * <br/>
 * 如果word存在于网格中，返回true；否则返回false。
 * </p>
 *
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中相邻单元格时那些水平相邻或垂直相邻的单元格。
 * <br/>
 * 同一个单元格内的字母不允许被重复使用。
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg"/>
 * <br/>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * <br/>
 * 输出：true
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg"/>
 * <br/>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * <br/>
 * 输出：true
 * </p>
 *
 * <p>
 * 示例三：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg"/>
 * <br/>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * <br/>
 * 输出：false
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * m == board.length
 * <br/>
 * n == board[i].length
 * <br/>
 * 1 <= m, n <= 6
 * <br/>
 * 1 <= word.length <= 15
 * <br/>
 * board和word仅由大小写英文字母组成
 * </p>
 *
 * <p>
 * 进阶：
 * <br/>
 * 你可以使用搜索剪枝的技术来优化解决方案，使其在board更大的情况下可以更快解决问题？
 * </p>
 */
class Solution {

    /**
     * 回溯、深度有限搜索
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 是否越界、是否是目标字符
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != words[k]) {
            return false;
        }
        // 所有字符都被搜索到了
        if (k == words.length - 1) {
            return true;
        }
        // 将被搜索到的字符设置为空字符，以免重复搜索
        board[i][j] = '\0';
        // 4个搜索方向(下上右左)搜索下一个字符
        // 这里短路或会在命中一个分支后跳过余下的分支
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1)
                   || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
        // 回溯，还原上一轮的状态
        board[i][j] = words[k];
        return res;
    }

}
