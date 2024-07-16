package io.huhu.leetcode.classic.other.n3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodeTest {

    Code code;

    @BeforeEach
    void setup() {
        code = new Code();
    }

    @Test
    void test_1() {
        int[] nums = {5, 6, -2, 7};
        Assertions.assertEquals(13, code.maxSumOfSubarray(nums, 2));
    }

    @Test
    void test_2() {
        int[] nums = {5, 6, -2, 7};
        Assertions.assertEquals(18, code.maxSumOfSubarray(nums, 3));
    }

}
