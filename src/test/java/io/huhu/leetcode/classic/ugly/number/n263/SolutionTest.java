package io.huhu.leetcode.classic.ugly.number.n263;

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
    void test1() {
        Assertions.assertTrue(solution.isUgly(6));
    }

    @Test
    void test2() {
        Assertions.assertTrue(solution.isUgly(1));
    }

    @Test
    void test3() {
        Assertions.assertFalse(solution.isUgly(14));
    }

}