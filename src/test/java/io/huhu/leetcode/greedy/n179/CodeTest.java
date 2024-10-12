package io.huhu.leetcode.greedy.n179;

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
        int[] nums = {10, 2};
        Assertions.assertEquals("210", code.largestNumber(nums));
    }

    @Test
    void test_2() {
        int[] nums = {3, 30, 34, 5, 9};
        Assertions.assertEquals("9534330", code.largestNumber(nums));
    }

}
