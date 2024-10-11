package io.huhu.leetcode.n368;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        var actual = code.largestDivisibleSubset(nums);
        actual.sort(Integer::compare);
        Assertions.assertIterableEquals(List.of(1, 2), actual);
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 4, 8};
        var actual = code.largestDivisibleSubset(nums);
        actual.sort(Integer::compare);
        Assertions.assertIterableEquals(List.of(1, 2, 4, 8), actual);
    }

}
