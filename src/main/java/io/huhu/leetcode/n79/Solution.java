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

    public boolean exist(char[][] board, String word) {
        // todo
        int x = 0;
        int y = 0;
        boolean[] isFind = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = x; j < board.length - 1; j++) {
                for (int k = y; k < board[j].length - 1; k++) {
                    if (i == 0 && c == board[j][k]) {
                        x = j;
                        y = k;
                        isFind[i] = true;
                    } else if (c == board[j + 1][k]) {
                        x = j + 1;
                        y = k;
                        isFind[i] = true;
                    } else if (c == board[j][k + 1]) {
                        x = j;
                        y = k + 1;
                        isFind[i] = true;
                    }
                }
            }
            if (!isFind[i]) {
                return false;
            }
        }
        return true;
    }

}
