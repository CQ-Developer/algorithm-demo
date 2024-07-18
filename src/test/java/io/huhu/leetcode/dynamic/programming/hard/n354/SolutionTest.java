package io.huhu.leetcode.dynamic.programming.hard.n354;

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
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Assertions.assertEquals(3, solution.maxEnvelopes(envelopes));
    }

    @Test
    void test_2() {
        int[][] envelopes = {{1, 1}, {1, 1}, {1, 1}};
        Assertions.assertEquals(1, solution.maxEnvelopes(envelopes));
    }

}
