package io.huhu.leetcode.n698;

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
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        Assertions.assertTrue(code.canPartitionKSubsets(nums, 4));
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(code.canPartitionKSubsets(nums, 3));
    }

}