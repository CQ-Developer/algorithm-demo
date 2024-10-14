package io.huhu.leetcode.n486;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        int[] nums = {1, 5, 2};
        Assertions.assertFalse(code.predictTheWinner(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 5, 233, 7};
        Assertions.assertTrue(code.predictTheWinner(nums));
    }

}