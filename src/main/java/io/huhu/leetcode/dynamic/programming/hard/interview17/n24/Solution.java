package io.huhu.leetcode.dynamic.programming.hard.interview17.n24;

/**
 * <a href="https://leetcode.cn/problems/max-submatrix-lcci/description/">
 * Max Submatrix LCCI
 * </a>
 */
class Solution {

    public int[] getMaxMatrix(int[][] matrix) {
        int a = 0, b = 0, c = 0, d = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] nums = new int[matrix[i].length];
            for (int j = i; j < matrix.length; j++) {
                int pre = Integer.MIN_VALUE;
                for (int l = 0, r = 0; r < matrix[j].length; r++) {
                    nums[r] += matrix[j][r];
                    if (pre >= 0) {
                        pre += nums[r];
                    } else {
                        pre = nums[r];
                        l = r;
                    }
                    if (pre > max) {
                        max = pre;
                        a = i;
                        b = l;
                        c = j;
                        d = r;
                    }
                }
            }
        }
        return new int[]{a, b, c, d};
    }

}
