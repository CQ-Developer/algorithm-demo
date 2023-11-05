package io.huhu.leetcode.back.trace.n37;

/**
 * <h1><a href="https://leetcode.cn/problems/sudoku-solver/">37.解数独</a></h1>
 * 编写一个程序, 通过填充空格来解决数独问题
 * <br/>
 * 数独的解法需要遵循如下规则:
 * <br/>
 * 1.数字1-9在每一行只能出现一次
 * <br/>
 * 2.数字1-9在每一列只能出现一次
 * <br/>
 * 3.数字1-9在每一个以粗线分割的3*3宫内只能出现一次
 * <br/>
 * 数独部分空格内已填入数字, 空白格用'.'表示
 */
class Solution {

    /**
     * 0表示当前行无值, 1表示当前行有值
     */
    private final int[] rows = new int[9];

    /**
     * 0表示当前列无值, 1表示当前列有值
     */
    private final int[] cols = new int[9];

    /**
     * 0表示当前3*3单元格无值, 1表示当前3*3单元格有值
     */
    private final int[][] cell = new int[3][3];

    /**
     * board.length == 9
     * <br/>
     * board[i].length == 9
     * <br/>
     * board[i][j]是一位数字或者'.'
     * <br/>
     * 题目数据保证输入数独仅有一个解
     */
    public void solveSudoku(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    count++;
                } else {
                    int n = c - '0';
                    fillNumber(i, j, n, true);
                }
            }
        }
        backTrace(board, count);
    }

    private boolean backTrace(char[][] board, int count) {
        if (count == 0) {
            return true;
        }
        int[] pos = getMinOkMaskCountPos(board);
        int i = pos[0];
        int j = pos[1];
        int okMask = getOkMask(i, j);
        for (char c = '1'; c <= '9'; c++) {
            int idx = c - '0';
            if (testMask(okMask, idx)) {
                fillNumber(i, j, idx, true);
                board[i][j] = c;
                if (backTrace(board, count - 1)) {
                    return true;
                }
                board[i][j] = '.';
                fillNumber(i, j, idx, false);
            }
        }
        return false;
    }

    private void fillNumber(int i, int j, int n, boolean fill) {
        rows[i] = fill ? rows[i] | (1 << n) : rows[i] & ~(1 << n);
        cols[j] = fill ? cols[j] | (1 << n) : cols[j] & ~(1 << n);
        cell[i / 3][j / 3] = fill ? cell[i / 3][j / 3] | (1 << n) : cell[i / 3][j / 3] & ~(1 << n);
    }

    private int[] getMinOkMaskCountPos(char[][] board) {
        int[] res = new int[2];
        int min = 10;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    int okMask = getOkMask(i, j);
                    int count = getOneCountInMask(okMask);
                    if (count < min) {
                        min = count;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }

    private int getOkMask(int x, int y) {
        return ~(rows[x] | cols[y] | cell[x / 3][y / 3]);
    }

    private boolean testMask(int mask, int index) {
        return (mask & (1 << index)) != 0;
    }

    private int getOneCountInMask(int mask) {
        int res = 0;
        for (int i = 0; i < 9; i++) {
            int test = 1 << i;
            if ((mask & test) != 0) {
                res++;
            }
        }
        return res;
    }

}
