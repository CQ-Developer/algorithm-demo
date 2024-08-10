package io.huhu.leetcode.dynamic.programming.medium.interview08.n14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    protected abstract Solution getSolution();

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(2, solution.countEval("1^0|0|1", 0));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(10, solution.countEval("0&0&0&1^1|0", 1));
    }

}
