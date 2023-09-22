package io.huhu.leetcode.n50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void myPow() {
        double result = solution.myPow(2, 3);
        assertEquals(8, result);
    }

    @Test
    void myPow1() {
        double result = solution.myPow(3, 2);
        assertEquals(9, result);
    }

}
