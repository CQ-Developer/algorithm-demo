package io.huhu.leetcode.n53;

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
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assertions.assertEquals(6, code.maxSubArray(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1};
        Assertions.assertEquals(1, code.maxSubArray(nums));
    }

    void test_3() {
        int[] nums = {5, 4, -1, 7, 8};
        Assertions.assertEquals(23, code.maxSubArray(nums));
    }

}
