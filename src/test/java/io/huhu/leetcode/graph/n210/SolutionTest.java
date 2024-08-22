package io.huhu.leetcode.graph.n210;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] actual = solution.findOrder(numCourses, prerequisites);
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_2() {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] actual = solution.findOrder(numCourses, prerequisites);
        int[] expected = {0, 1, 2, 3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_3() {
        int numCourses = 1;
        int[][] prerequisites = {};
        int[] actual = solution.findOrder(numCourses, prerequisites);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual);
    }

}
