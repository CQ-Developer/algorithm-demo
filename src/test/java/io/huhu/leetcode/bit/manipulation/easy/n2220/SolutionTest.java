package io.huhu.leetcode.bit.manipulation.easy.n2220;

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
    void minBitFlips_1() {
        Assertions.assertEquals(3, solution.minBitFlips(10, 7));
    }

    @Test
    void minBitFlip_2() {
        Assertions.assertEquals(3, solution.minBitFlips(3, 4));
    }

}
