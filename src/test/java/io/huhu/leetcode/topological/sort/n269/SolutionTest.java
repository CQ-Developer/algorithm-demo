package io.huhu.leetcode.topological.sort.n269;

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
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        Assertions.assertEquals("wertf", solution.alienOrder(words));
    }

    @Test
    void test_2() {
        String[] words = {"z", "x"};
        Assertions.assertEquals("zx", solution.alienOrder(words));
    }

    @Test
    void test_3() {
        String[] words = {"z", "x", "z"};
        Assertions.assertEquals("", solution.alienOrder(words));
    }

}
