package io.huhu.leetcode.back.trace.lcp.n51;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void perfectMenu_1() {
        int[] materials = {3, 2, 4, 1, 2};
        int[][] cookbooks = {
                {1, 1, 0, 1, 2},
                {2, 1, 4, 0, 0},
                {3, 2, 4, 1, 0}};
        int[][] attribute = {
                {3, 2},
                {2, 4},
                {7, 6}};
        int limit = 5;
        Assertions.assertEquals(7, solution.perfectMenu(materials, cookbooks, attribute, limit));
    }

    @Test
    void perfectMenu_2() {
        int[] materials = {10, 10, 10, 10, 10};
        int[][] cookbooks = {
                {1, 1, 1, 1, 1},
                {3, 3, 3, 3, 3},
                {10, 10, 10, 10, 10}};
        int[][] attribute = {
                {5, 5},
                {6, 6},
                {10, 10}};
        int limit = 1;
        Assertions.assertEquals(11, solution.perfectMenu(materials, cookbooks, attribute, limit));
    }

}
