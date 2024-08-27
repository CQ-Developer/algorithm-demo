package io.huhu.leetcode.topological.sort.n2050;

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
        int[][] relations = {{1, 3}, {2, 3}};
        int[] time = {3, 2, 5};
        Assertions.assertEquals(8, solution.minimumTime(3, relations, time));
    }

    @Test
    void test_2() {
        int[][] relations = {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] time = {1, 2, 3, 4, 5};
        Assertions.assertEquals(12, solution.minimumTime(5, relations, time));
    }

}
