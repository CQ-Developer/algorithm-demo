package io.huhu.leetcode.n57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void insert_1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] expected = {{1, 5}, {6, 9}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void insert_2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void insert_3() {
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] expected = {{5, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void insert_4() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void insert_5() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] expected = {{1, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void insert_6() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 3};
        int[][] expected = {{0, 5}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

}
