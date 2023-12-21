package io.huhu.leetcode.back.trace.interview.questions.n08.n02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        List<List<Integer>> actual = solution.pathWithObstacles(obstacleGrid);
        List<List<Integer>> expected = List.of(List.of(0, 0), List.of(0, 1), List.of(0, 2), List.of(1, 2), List.of(2, 2));
        Assertions.assertIterableEquals(expected, actual);
    }

}
