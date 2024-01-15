package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n03;

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
    void reverseBits_1() {
        Assertions.assertEquals(8, solution.reverseBits(1775));
    }

    @Test
    void reverseBits_2() {
        Assertions.assertEquals(4, solution.reverseBits(7));
    }

}
