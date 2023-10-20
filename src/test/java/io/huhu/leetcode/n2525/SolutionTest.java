package io.huhu.leetcode.n2525;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void categorizeBox_1() {
        assertEquals("Heavy", solution.categorizeBox(1000, 35, 700, 300));
    }

    @Test
    void categorizeBox_2() {
        assertEquals("Neither", solution.categorizeBox(200, 50, 800, 50));
    }

}
