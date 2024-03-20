package io.huhu.leetcode.dynamic.programming.medium.n62;

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
        assertEquals(28, solution.uniquePaths(3, 7));
    }

    @Test
    void test_2() {
        assertEquals(3, solution.uniquePaths(3, 2));
    }

    @Test
    void test_3() {
        assertEquals(28, solution.uniquePaths(7, 3));
    }

    @Test
    void test_4() {
        assertEquals(6, solution.uniquePaths(3, 3));
    }

}
