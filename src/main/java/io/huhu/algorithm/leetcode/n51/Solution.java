package io.huhu.algorithm.leetcode.n51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>51.N皇后</h1>
 * <p>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <br>
 * <b>n皇后问题</b>研究的是如何将n个皇后放置在n*n的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <br>
 * 给你一个整数n，返回所有不同的n皇后问题的解决方案。
 * <br>
 * 每一种解法包含一个不同的n皇后问题的棋子放置方案，该方案中<b>'Q'</b>和<b>'.'</b>分别代表了皇后和空位。
 * </p>
 * <p>
 * <b>示例一：</b>
 * <br>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg">
 * 输入：n=4
 * <br>
 * 输出:[[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]
 * </p>
 * <p>
 * <b>示例二：</b>
 * <br>
 * 输入：n=1
 * <br>
 * 输出：[["Q"]]
 * </p>
 * <p>
 * <b>提示：</b>
 * <br>
 * 1 <= n <= 9
 * </p>
 */
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonalsL = new HashSet<>();
        Set<Integer> diagonalsR = new HashSet<>();
        backTrack(solution, queens, n, 0, columns, diagonalsL, diagonalsR);
        return solution;
    }

    private void backTrack(List<List<String>> solution, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonalsL, Set<Integer> diagonalsR) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solution.add(board);
        }
        else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonalL = row - i;
                if (diagonalsL.contains(diagonalL)) {
                    continue;
                }
                int diagonalR = row + i;
                if (diagonalsR.contains(diagonalR)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonalsL.add(diagonalL);
                diagonalsR.add(diagonalR);
                backTrack(solution, queens, n, row + 1, columns, diagonalsL, diagonalsR);
                queens[row] = -1;
                columns.remove(i);
                diagonalsL.remove(diagonalL);
                diagonalsR.remove(diagonalR);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
