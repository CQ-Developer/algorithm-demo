package io.huhu.leetcode.back.trace.n996;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void numSquarefulPerms_1() {
        int[] nums = {1, 17, 8};
        Assertions.assertEquals(2, solution.numSquarefulPerms(nums));
    }

    @Test
    void numSquarefulPerms_2() {
        int[] nums = {2, 2, 2};
        Assertions.assertEquals(1, solution.numSquarefulPerms(nums));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4})
    void numSquarefulPerms_3(int n) {
        int[] nums = {n};
        Assertions.assertEquals(1, solution.numSquarefulPerms(nums));
    }

    @Test
    void numSquarefulPerms_4() {
        int[] nums = {75, 91, 39, 33, 39, 39, 69, 20, 43, 38, 48, 29};
        Assertions.assertEquals(0, solution.numSquarefulPerms(nums));
    }

}
