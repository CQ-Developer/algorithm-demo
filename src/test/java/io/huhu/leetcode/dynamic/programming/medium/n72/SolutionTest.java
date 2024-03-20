package io.huhu.leetcode.dynamic.programming.medium.n72;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        assertEquals(3, solution.minDistance("horse", "ros"));
    }

    @Test
    void test_2() {
        assertEquals(5, solution.minDistance("intention", "execution"));
    }

}
