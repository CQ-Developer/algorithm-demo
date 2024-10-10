package io.huhu.leetcode.n396;

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
        int[] nums = {4, 3, 2, 6};
        Assertions.assertEquals(26, code.maxRotateFunction(nums));
    }

    @Test
    void test_2() {
        int[] nums = {100};
        Assertions.assertEquals(0, code.maxRotateFunction(nums));
    }

}
