package io.huhu.leetcode.dynamic.programming.medium.n96;

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
        Assertions.assertEquals(1, solution.numTrees(1));
    }

    @Test
    void case_2() {
        Assertions.assertEquals(2, solution.numTrees(2));
    }

    @Test
    void case_3() {
        Assertions.assertEquals(5, solution.numTrees(3));
    }

    @Test
    void case_4() {
        Assertions.assertEquals(14, solution.numTrees(4));
    }

    @Test
    void case_5() {
        Assertions.assertEquals(42, solution.numTrees(5));
    }

}