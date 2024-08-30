package io.huhu.leetcode.binary.tree.hard.n2322;

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
        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        Assertions.assertEquals(9, solution.minimumScore(nums, edges));
    }

    @Test
    void test_2() {
        int[] nums = {5, 5, 2, 4, 4, 2};
        int[][] edges = {{0, 1}, {1, 2}, {5, 2}, {4, 3}, {1, 3}};
        Assertions.assertEquals(0, solution.minimumScore(nums, edges));
    }

}
