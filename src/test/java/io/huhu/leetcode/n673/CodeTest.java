package io.huhu.leetcode.n673;

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
        int[] nums = {1, 3, 5, 4, 7};
        Assertions.assertEquals(2, code.findNumberOfLIS(nums));
    }

    @Test
    void test_2() {
        int[] nums = {2, 2, 2, 2, 2};
        Assertions.assertEquals(5, code.findNumberOfLIS(nums));
    }

}