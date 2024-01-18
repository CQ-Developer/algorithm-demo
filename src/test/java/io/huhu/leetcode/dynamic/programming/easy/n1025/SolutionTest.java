package io.huhu.leetcode.dynamic.programming.easy.n1025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void divisorGame_true() {
        Assertions.assertTrue(solution.divisorGame(2));
    }

    @Test
    void divisorGame_false() {
        Assertions.assertFalse(solution.divisorGame(3));
    }

}
