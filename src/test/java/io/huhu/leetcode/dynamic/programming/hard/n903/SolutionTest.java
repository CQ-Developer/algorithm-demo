package io.huhu.leetcode.dynamic.programming.hard.n903;

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
        Assertions.assertEquals(5, solution.numPermsDISequence("DID"));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(1, solution.numPermsDISequence("D"));
    }

}
