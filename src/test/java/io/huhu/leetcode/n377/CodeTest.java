package io.huhu.leetcode.n377;

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
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(7, code.combinationSum4(nums, 4));
    }

    @Test
    void test_2() {
        int[] nums = {9};
        Assertions.assertEquals(0, code.combinationSum4(nums, 3));
    }

}
