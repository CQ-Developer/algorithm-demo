package io.huhu.leetcode.dynamic.programming.hard.n514;

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
        Assertions.assertEquals(4, solution.findRotateSteps("godding", "gd"));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(13, solution.findRotateSteps("godding", "godding"));
    }

}
