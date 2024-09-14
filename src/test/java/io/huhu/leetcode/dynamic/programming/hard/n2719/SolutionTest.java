package io.huhu.leetcode.dynamic.programming.hard.n2719;

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
        Assertions.assertEquals(11, solution.count("1", "12", 1, 8));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(5, solution.count("1", "5", 1, 5));
    }

}
