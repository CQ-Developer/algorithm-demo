package io.huhu.leetcode.n416;

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
        int[] nums = {1, 5, 11, 5};
        Assertions.assertTrue(code.canPartition(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 3, 5};
        Assertions.assertFalse(code.canPartition(nums));
    }

}
