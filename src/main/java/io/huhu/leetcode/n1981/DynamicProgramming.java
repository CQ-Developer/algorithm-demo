package io.huhu.leetcode.n1981;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] f = new boolean[2 * target + 1];
        f[0] = true;
        int minSum = 0, maxSum = 0;
        for (int[] row : mat) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num : row) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            minSum += min;
            maxSum = Math.min(maxSum + max, target * 2);
            for (int j = maxSum; j >= 0; j--) {
                f[j] = false;
                for (int num : row) {
                    if (j >= num && f[j - num]) {
                        f[j] = true;
                        break;
                    }
                }
            }
        }
        int res = Math.abs(minSum - target);
        for (int j = 1; j <= target * 2; j++) {
            if (f[j]) {
                res = Math.min(res, Math.abs(j - target));
            }
        }
        return res;
    }

}
