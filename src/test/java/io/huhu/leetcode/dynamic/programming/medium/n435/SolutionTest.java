package io.huhu.leetcode.dynamic.programming.medium.n435;

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
    void test1() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Assertions.assertEquals(1, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void test2() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        Assertions.assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void test3() {
        int[][] intervals = {{1, 2}, {2, 3}};
        Assertions.assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    void test4() {
        int[][] intervals = {{1, 2}};
        Assertions.assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }

}
