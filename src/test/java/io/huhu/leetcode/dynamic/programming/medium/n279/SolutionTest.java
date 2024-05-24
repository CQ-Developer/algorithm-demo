package io.huhu.leetcode.dynamic.programming.medium.n279;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(3, solution.numSquares(12));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(2, solution.numSquares(13));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(1, solution.numSquares(10000));
    }

    @Test
    void test_4() {
        Assertions.assertEquals(4, solution.numSquares(999));
    }

}
