package io.huhu.leetcode.back.trace.n52;

/**
 * <a href="https://leetcode.cn/problems/n-queens-ii/description/">N皇后II</a>
 * <p>n皇后问题研究的是如何将n个皇后放置在nxn的棋盘上, 并且使皇后彼此之间不能相互攻击.
 * <p>给你一个整数n, 返回n皇后问题不同的解决方案数量.
 * <p>提示:
 * <ul>
 * <li>1 <= n <= 9
 * </ul>
 */
class Solution {

    public int totalNQueens(int n) {
        return backTracing(new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], n, 0);
    }

    private int backTracing(boolean[] col, boolean[] dl, boolean[] dr, int n, int i) {
        if (i == n) {
            return 1;
        }
        int total = 0;
        for (int j = 0; j < n; j++) {
            if (col[j]) {
                continue;
            }
            int l = i - j < 0 ? dl.length + (i - j) : i - j;
            if (dl[l]) {
                continue;
            }
            int r = i + j;
            if (dr[r]) {
                continue;
            }
            col[j] = true;
            dl[l] = true;
            dr[r] = true;
            total += backTracing(col, dl, dr, n, i + 1);
            col[j] = false;
            dl[l] = false;
            dr[r] = false;
        }
        return total;
    }

}
