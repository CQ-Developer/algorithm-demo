package io.huhu.leetcode.n152;

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
        int[] nums = {2, 3, -2, 4};
        Assertions.assertEquals(6, code.maxProduct(nums));
    }

    @Test
    void test_2() {
        int[] nums = {-2, 0, -1};
        Assertions.assertEquals(0, code.maxProduct(nums));
    }

}
