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

    @Test
    void isAdditiveNumber_7() {
        Assertions.assertTrue(solution.isAdditiveNumber("101"));
    }

    @Test
    void isAdditiveNumber_8() {
        Assertions.assertTrue(solution.isAdditiveNumber("011"));
    }

    @Test
    void isAdditiveNumber_9() {
        Assertions.assertFalse(solution.isAdditiveNumber("0110"));
    }

    @Test
    void isAdditiveNumber_10() {
        Assertions.assertFalse(solution.isAdditiveNumber("0101"));
    }

    @Test
    void isAdditiveNumber_11() {
        Assertions.assertFalse(solution.isAdditiveNumber("19910011992"));
    }

    @Test
    void isAdditiveNumber_12() {
        Assertions.assertFalse(solution.isAdditiveNumber("11235813213455890144"));
    }

}
