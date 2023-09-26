package io.huhu.leetcode.n56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void merge_1() {
        int[][] expected = {{1, 5}};
        int[][] intervals = {{1, 4}, {4, 5}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void merge_2() {
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

    @Test
    void merge_3() {
        // todo 用例错误
        int[][] expected = {{0, 4}};
        int[][] intervals = {{1, 4}, {0, 4}};
        assertArrayEquals(expected, solution.merge(intervals));
    }

}
