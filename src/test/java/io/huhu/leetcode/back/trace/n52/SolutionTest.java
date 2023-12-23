package io.huhu.leetcode.back.trace.n52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        Assertions.assertEquals(2, solution.totalNQueens(4));
    }

    @Test
    void case_2() {
        Assertions.assertEquals(1, solution.totalNQueens(1));
    }

    @Test
    void case_3() {
        Assertions.assertEquals(352, solution.totalNQueens(9));
    }

}
