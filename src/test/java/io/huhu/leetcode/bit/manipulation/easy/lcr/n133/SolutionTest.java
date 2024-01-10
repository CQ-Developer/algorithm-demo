package io.huhu.leetcode.bit.manipulation.easy.lcr.n133;

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
    void hammingWeight_1() {
        Assertions.assertEquals(3, solution.hammingWeight(11));
    }

    @Test
    void hammingWeight_2() {
        Assertions.assertEquals(1, solution.hammingWeight(128));
    }

    @Test
    void hammingWeight_3() {
        Assertions.assertEquals(31, solution.hammingWeight(-3));
    }

}
