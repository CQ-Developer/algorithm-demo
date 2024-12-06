package io.huhu.leetcode.n1981;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Solution {

    @Override
    public int minimizeTheDifference(int[][] mat, int target) {
        return f(mat, target, 0);
    }

    private int f(int[][] mat, int target, int i) {
        if (i == mat.length) {
            return Math.abs(target);
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < mat[i].length; j++) {
            res = Math.min(res, f(mat, target - mat[i][j], i + 1));
        }
        return res;
    }

}
