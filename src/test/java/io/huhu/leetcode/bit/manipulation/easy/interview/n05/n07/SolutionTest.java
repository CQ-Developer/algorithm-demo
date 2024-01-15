package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n07;

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
    void exchangeBits_1() {
        Assertions.assertEquals(1, solution.exchangeBits(2));
    }

    @Test
    void exchangeBits_2() {
        Assertions.assertEquals(3, solution.exchangeBits(3));
    }

}
