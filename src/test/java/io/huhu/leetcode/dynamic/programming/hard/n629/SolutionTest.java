package io.huhu.leetcode.dynamic.programming.hard.n629;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(1, solution.kInversePairs(3, 0));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(2, solution.kInversePairs(3, 1));
    }

}
