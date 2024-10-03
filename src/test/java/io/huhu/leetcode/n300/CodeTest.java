package io.huhu.leetcode.n300;

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
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Assertions.assertEquals(4, code.lengthOfLIS(nums));
    }

    @Test
    void test_2() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        Assertions.assertEquals(4, code.lengthOfLIS(nums));
    }

    @Test
    void test_3() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        Assertions.assertEquals(1, code.lengthOfLIS(nums));
    }

}
