package io.huhu.leetcode.n494;

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
        int[] nums = {1, 1, 1, 1, 1};
        Assertions.assertEquals(5, code.findTargetSumWays(nums, 3));
    }

    @Test
    void test_2() {
        int[] nums = {1};
        Assertions.assertEquals(1, code.findTargetSumWays(nums, 1));
    }

}
