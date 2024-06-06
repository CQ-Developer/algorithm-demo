package io.huhu.leetcode.dynamic.programming.medium.n357;

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
        Assertions.assertEquals(91, solution.countNumbersWithUniqueDigits(2));
    }

    @Test
    void test2() {
        Assertions.assertEquals(1, solution.countNumbersWithUniqueDigits(0));
    }

    @Test
    void test3() {
        Assertions.assertEquals(10, solution.countNumbersWithUniqueDigits(1));
    }

    @Test
    void test4() {
        Assertions.assertEquals(739, solution.countNumbersWithUniqueDigits(3));
    }

}
