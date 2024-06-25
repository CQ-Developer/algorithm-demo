package io.huhu.leetcode.dynamic.programming.medium.n467;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        Assertions.assertEquals(1, solution.findSubstringInWraproundString("a"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(2, solution.findSubstringInWraproundString("cac"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(6, solution.findSubstringInWraproundString("zab"));
    }

}
