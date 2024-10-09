package io.huhu.leetcode.n376;

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
        int[] nums = {1, 7, 4, 9, 2, 5};
        Assertions.assertEquals(6, code.wiggleMaxLength(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Assertions.assertEquals(7, code.wiggleMaxLength(nums));
    }

    @Test
    void test_3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertEquals(2, code.wiggleMaxLength(nums));
    }

}