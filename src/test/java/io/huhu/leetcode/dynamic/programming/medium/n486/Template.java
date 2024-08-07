package io.huhu.leetcode.dynamic.programming.medium.n486;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class Template {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    protected abstract Solution getSolution();

    @Test
    void test_1() {
        int[] nums = {1, 5, 2};
        Assertions.assertFalse(solution.predictTheWinner(nums));
    }

    @Test
    void test_2() {
        int[] nums = {1, 5, 233, 7};
        Assertions.assertTrue(solution.predictTheWinner(nums));
    }

}
