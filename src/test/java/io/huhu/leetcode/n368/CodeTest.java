package io.huhu.leetcode.n368;

import java.util.List;

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
        Assertions.assertIterableEquals(List.of(1, 2), code.largestDivisibleSubset(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 4, 8};
        Assertions.assertIterableEquals(List.of(1, 2, 4, 8), code.largestDivisibleSubset(nums));
    }

}
