package io.huhu.leetcode.n1981;

import io.huhu.AC;

import java.math.BigInteger;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int minimizeTheDifference(int[][] mat, int target) {
        BigInteger f = BigInteger.ONE;
        for (int[] row : mat) {
            BigInteger g = BigInteger.ZERO;
            for (int num : row) {
                g = g.or(f.shiftLeft(num));
            }
            f = g;
        }
        for (int d = 0; ; d++) {
            if (f.testBit(target + d) || target > d && f.testBit(target - d)) {
                return d;
            }
        }
    }

}
