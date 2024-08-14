package io.huhu.leetcode.dynamic.programming.hard.n1000;

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
        int[] stones = {3, 2, 4, 1};
        Assertions.assertEquals(20, solution.mergeStones(stones, 2));
    }

    @Test
    void test_2() {
        int[] stones = {3, 2, 4, 1};
        Assertions.assertEquals(-1, solution.mergeStones(stones, 3));
    }

    @Test
    void test_3() {
        int[] stones = {3, 5, 1, 2, 6};
        Assertions.assertEquals(25, solution.mergeStones(stones, 3));
    }

}