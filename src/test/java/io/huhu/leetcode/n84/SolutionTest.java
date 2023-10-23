package io.huhu.leetcode.n84;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void largestRectangleArea1() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        assertEquals(10, solution.largestRectangleArea(heights));
    }

    @Test
    void largestRectangleArea2() {
        int[] heights = {2, 4};
        assertEquals(4, solution.largestRectangleArea(heights));
    }

    @Test
    void largestRectangleArea3() {
        int[] heights = {2, 1, 2};
        assertEquals(3, solution.largestRectangleArea(heights));
    }

}
