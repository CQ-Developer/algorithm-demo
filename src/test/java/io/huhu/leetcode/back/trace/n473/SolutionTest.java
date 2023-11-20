package io.huhu.leetcode.back.trace.n473;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void makesquare_1() {
        int[] matchsticks = {1, 1, 2, 2, 2};
        Assertions.assertTrue(solution.makesquare(matchsticks));
    }

    @Test
    void makesquare_2() {
        int[] matchsticks = {3, 3, 3, 3, 4};
        Assertions.assertFalse(solution.makesquare(matchsticks));
    }

    @Test
    void makesquare_3() {
        int[] matchsticks = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        Assertions.assertTrue(solution.makesquare(matchsticks));
    }

    @Test
    void makesquare_4() {
        int[] matchsticks = {1, 1, 2};
        Assertions.assertFalse(solution.makesquare(matchsticks));
    }

    @Test
    void makesquare_5() {
        int[] matchsticks = {1, 1, 1, 1};
        Assertions.assertTrue(solution.makesquare(matchsticks));
    }

    @Test
    void makesquare_6() {
        int[] matchsticks = {5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4};
        Assertions.assertFalse(solution.makesquare(matchsticks));
    }

}
