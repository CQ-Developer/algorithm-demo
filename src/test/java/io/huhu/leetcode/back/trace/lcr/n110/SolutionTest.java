package io.huhu.leetcode.back.trace.lcr.n110;

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
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 1, 3), List.of(0, 2, 3));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_3() {
        int[][] graph = {{1}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 1));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_4() {
        int[][] graph = {{1, 2, 3}, {2}, {3}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_5() {
        int[][] graph = {{1, 3}, {2}, {3}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 1, 2, 3), List.of(0, 3));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_6() {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {}, {4}, {}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 4));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_7() {
        int[][] graph = {{2}, {}, {1}};
        List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0, 2));
        Assertions.assertIterableEquals(expected, actual);
    }

}
