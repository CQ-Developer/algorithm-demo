package io.huhu.leetcode.dynamic.programming.hard.n546;

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
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        Assertions.assertEquals(23, solution.removeBoxes(boxes));
    }

    @Test
    void test_2() {
        int[] boxes = {1, 1, 1};
        Assertions.assertEquals(9, solution.removeBoxes(boxes));
    }

    @Test
    void test_3() {
        int[] boxes = {1};
        Assertions.assertEquals(1, solution.removeBoxes(boxes));
    }

}
