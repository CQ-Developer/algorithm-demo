package io.huhu.leetcode.n413;

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
        int[] nums = {1, 2, 3, 4};
        Assertions.assertEquals(3, code.numberOfArithmeticSlices(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1};
        Assertions.assertEquals(0, code.numberOfArithmeticSlices(nums));
    }

}