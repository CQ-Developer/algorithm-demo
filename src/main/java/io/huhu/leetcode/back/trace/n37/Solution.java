package io.huhu.leetcode.back.trace.n37;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/description/">解数独</a>
 * <p>编写一个程序, 通过填充空格来解决数独问题.
 * <p>数独的解法需要遵循如下规则:
 * <ol>
 * <li>数字1-9在每一行只能出现一次.
 * <li>数字1-9在一列只能出现一次.
 * <li>数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次.
 * </ol>
 * <p>数独部分空格内已填入了数字, 空白格用'.'表示.
 * <p>提示:
 * <ul>
 * <li>board.length == 9
 * <li>board[i].length == 9
 * <li>board[i][j]是一位数字或者'.'
 * <li>题目数据保证输入数独仅有一个解
 * </ul>
 */
class Solution {

    private final List<int[]> spaces = new ArrayList<>();
    private final boolean[][] row = new boolean[9][10];
    private final boolean[][] col = new boolean[9][10];
    private final boolean[][][] cell = new boolean[3][3][10];
    private final char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int[] space = {i, j};
                    spaces.add(space);
                } else {
                    int k = board[i][j] - '0';
                    row[i][k] = col[j][k] = cell[i / 3][j / 3][k] = true;
                }
            }
        }
        backTracing(board, 0);
    }

    private boolean backTracing(char[][] board, int p) {
        if (p == spaces.size()) {
            return true;
        }
        int i = spaces.get(p)[0], j = spaces.get(p)[1];
        for (int k = 1; k <= 9; k++) {
            if (row[i][k] || col[j][k] || cell[i / 3][j / 3][k]) {
                continue;
            }
            row[i][k] = col[j][k] = cell[i / 3][j / 3][k] = true;
            board[i][j] = nums[k];
            if (backTracing(board, p + 1)) {
                return true;
            }
            row[i][k] = col[j][k] = cell[i / 3][j / 3][k] = false;
        }
        return false;
    }

}
