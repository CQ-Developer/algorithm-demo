package io.huhu.leetcode.n553;

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
        int[] nums = {1000, 100, 10, 2};
        Assertions.assertEquals("1000/(100/10/2)", code.optimalDivision(nums));
    }

    @Test
    void test_2() {
        int[] nums = {2, 3, 4};
        Assertions.assertEquals("2/(3/4)", code.optimalDivision(nums));
    }

}