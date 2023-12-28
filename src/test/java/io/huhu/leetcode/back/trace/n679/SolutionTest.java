package io.huhu.leetcode.back.trace.n679;

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
    void judgePoint24_1() {
        int[] cards = {4, 1, 8, 7};
        Assertions.assertTrue(solution.judgePoint24(cards));
    }

    @Test
    void judgePoint24_2() {
        int[] cards = {1, 2, 1, 2};
        Assertions.assertFalse(solution.judgePoint24(cards));
    }

}
