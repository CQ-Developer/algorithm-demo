package io.huhu.leetcode.n62;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void uniquePaths_1() {
        assertEquals(3, solution.uniquePaths(3, 2));
    }

    @Test
    void uniquePaths_2() {
        assertEquals(28, solution.uniquePaths(3, 7));
    }

    @Test
    void uniquePaths_3() {
        assertEquals(28, solution.uniquePaths(7, 3));
    }

    @Test
    void uniquePaths_4() {
        assertEquals(6, solution.uniquePaths(3, 3));
    }

    @Test
    void uniquePaths_5() {
        assertEquals(1, solution.uniquePaths(1, 3));
    }

    @Test
    void uniquePaths_6() {
        assertEquals(1, solution.uniquePaths(3, 1));
    }

    @Test
    void uniquePaths_7() {
        assertEquals(1916797311, solution.uniquePaths(51, 9));
    }

    @Test
    void uniquePaths_8() {
        assertEquals(1596692176, solution.uniquePaths(50, 100));
    }

}
