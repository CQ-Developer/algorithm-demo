package io.huhu.leetcode.n213;

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
        int[] nums = {2, 3, 2};
        Assertions.assertEquals(3, code.rob(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 3, 1};
        Assertions.assertEquals(4, code.rob(nums));
    }

    @Test
    void test_3() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(3, code.rob(nums));
    }

}
