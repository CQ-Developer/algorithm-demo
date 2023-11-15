package io.huhu.leetcode.back.n306;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isAdditiveNumber_1() {
        Assertions.assertTrue(solution.isAdditiveNumber("112358"));
    }

    @Test
    void isAdditiveNumber_2() {
        Assertions.assertTrue(solution.isAdditiveNumber("199100199"));
    }

    @Test
    void isAdditiveNumber_3() {
        Assertions.assertTrue(solution.isAdditiveNumber("000000"));
    }

    @Test
    void isAdditiveNumber_4() {
        Assertions.assertFalse(solution.isAdditiveNumber("00"));
    }

    @Test
    void isAdditiveNumber_5() {
        Assertions.assertFalse(solution.isAdditiveNumber("111"));
    }

    @Test
    void isAdditiveNumber_6() {
        Assertions.assertTrue(solution.isAdditiveNumber("112358"));
    }

}
