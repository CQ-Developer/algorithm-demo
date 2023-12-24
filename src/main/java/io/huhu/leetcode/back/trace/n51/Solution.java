package io.huhu.leetcode.back.trace.n51;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens/description/">N皇后</a>
 * <p>按照国际象棋的规则, 皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子.
 * <p>N皇后问题研究的是如何将n个皇后放置在nxn的棋盘上, 并且使皇后彼此之间不能相互攻击.
 * <p>给你一个整数n, 返回所有不同的N皇后问题的解决方案.
 * <p>每一种解法包含不同的N皇后的棋子放置方案, 该方案中'Q'和'.'分别代表了皇后和空位.
 * <p>提示:
 * <ul>
 * <li>1 <= n <= 9
 * </ul>
 */
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backTracing(n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new int[n], 0, res);
        return res;
    }

    private void backTracing(int n, boolean[] col, boolean[] dls, boolean[] drs, int[] queue, int i, List<List<String>> res) {
        if (i == n) {
            res.add(draw(n, queue));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (col[j]) {
                continue;
            }
            int dl = i - j < 0 ? dls.length + i - j : i - j;
            if (dls[dl]) {
                continue;
            }
            int dr = i + j;
            if (drs[dr]) {
                continue;
            }
            col[j] = true;
            dls[dl] = true;
            drs[dr] = true;
            queue[i] = j;
            backTracing(n, col, dls, drs, queue, i + 1, res);
            col[j] = false;
            dls[dl] = false;
            drs[dr] = false;
        }
    }

    public List<String> draw(int n, int[] queue) {
        List<String> res = new ArrayList<>(n);
        for (int q : queue) {
            char[] chars = new char[n];
            for (int i = 0; i < n; i++) {
                chars[i] = i == q ? 'Q' : '.';
            }
            res.add(String.valueOf(chars));
        }
        return res;
    }

}
