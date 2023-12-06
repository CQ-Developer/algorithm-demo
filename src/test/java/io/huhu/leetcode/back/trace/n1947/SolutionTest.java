package io.huhu.leetcode.back.trace.n1947;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        int[][] students = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 1}};
        int[][] mentors = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 1, 0}};
        Assertions.assertEquals(8, solution.maxCompatibilitySum(students, mentors));
    }

    @Test
    void case_2() {
        int[][] students = {
                {0, 0},
                {0, 0},
                {0, 0}};
        int[][] mentors = {
                {1, 1},
                {1, 1},
                {1, 1}};
        Assertions.assertEquals(0, solution.maxCompatibilitySum(students, mentors));
    }

}
