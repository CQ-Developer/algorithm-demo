package io.huhu.leetcode.dynamic.programming.hard.n44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class Template {

    Solution solution;

    protected abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        Assertions.assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    void test_2() {
        Assertions.assertTrue(solution.isMatch("aa", "*"));
    }

    @Test
    void test_3() {
        Assertions.assertFalse(solution.isMatch("cb", "?a"));
    }

}
