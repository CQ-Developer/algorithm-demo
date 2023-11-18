package io.huhu.leetcode.back.trace.n357;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countNumbersWithUniqueDigits_0() {
        Assertions.assertEquals(1, solution.countNumbersWithUniqueDigits(0));
    }

    @Test
    void countNumbersWithUniqueDigits_1() {
        Assertions.assertEquals(10, solution.countNumbersWithUniqueDigits(1));
    }

    @Test
    void countNumbersWithUniqueDigits_2() {
        Assertions.assertEquals(91, solution.countNumbersWithUniqueDigits(2));
    }

    @Test
    void countNumbersWithUniqueDigits_3() {
        Assertions.assertEquals(739, solution.countNumbersWithUniqueDigits(3));
    }

    @Test
    void countNumbersWithUniqueDigits_4() {
        Assertions.assertEquals(5275, solution.countNumbersWithUniqueDigits(4));
    }

    @Test
    void countNumbersWithUniqueDigits_5() {
        Assertions.assertEquals(32491, solution.countNumbersWithUniqueDigits(5));
    }

}
