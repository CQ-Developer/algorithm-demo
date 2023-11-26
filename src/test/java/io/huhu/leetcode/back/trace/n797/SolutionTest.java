package io.huhu.leetcode.back.trace.n797;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        this.solution = new Solution();
    }

    @Test
    void allPathsSourceTarget1() {
        List<List<Integer>> expected = List.of(
                List.of(0, 1, 3),
                List.of(0, 2, 3));
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void allPathsSourceTarget2() {
        List<List<Integer>> expected = List.of(
                List.of(0, 4),
                List.of(0, 3, 4),
                List.of(0, 1, 3, 4),
                List.of(0, 1, 2, 3, 4),
                List.of(0, 1, 4));
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        Assertions.assertIterableEquals(expected, actual);
    }

}
