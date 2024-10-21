package io.huhu.leetcode.n740;

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
        int[] nums = {3, 4, 2};
        Assertions.assertEquals(6, code.deleteAndEarn(nums));
    }

    @Test
    void test_2() {
        int[] nums = {2, 2, 3, 3, 3, 4};
        Assertions.assertEquals(9, code.deleteAndEarn(nums));
    }

}
