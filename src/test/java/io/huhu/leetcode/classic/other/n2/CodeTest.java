package io.huhu.leetcode.classic.other.n2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        int[] nums = {-3, -4, 5, 6, -7, -8, 3, 4, -9};
        Assertions.assertEquals(18, code.maximumSumOfSubarray(nums));
    }

    protected abstract Code getCode();

}
