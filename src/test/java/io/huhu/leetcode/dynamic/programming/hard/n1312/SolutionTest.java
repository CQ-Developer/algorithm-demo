package io.huhu.leetcode.dynamic.programming.hard.n1312;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    protected abstract Solution getSolution();

    @Test
    void test_1() {
        Assertions.assertEquals(0, solution.minInsertions("zzazz"));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(2, solution.minInsertions("mbadm"));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(5, solution.minInsertions("leetcode"));
    }

}
