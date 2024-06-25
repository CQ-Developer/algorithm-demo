package io.huhu.leetcode.dynamic.programming.medium.n464;

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
        Assertions.assertFalse(solution.canIWin(10, 11));
    }

    @Test
    void test2() {
        Assertions.assertTrue(solution.canIWin(10, 0));
    }

    @Test
    void test3() {
        Assertions.assertTrue(solution.canIWin(10, 1));
    }

    @Test
    void test4() {
        Assertions.assertFalse(solution.canIWin(10, 40));
    }

    @Test
    void test5() {
        Assertions.assertTrue(solution.canIWin(20, 100));
    }

    @Test
    void test6() {
        Assertions.assertFalse(solution.canIWin(5, 50));
    }

}
