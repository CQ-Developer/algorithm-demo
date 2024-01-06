package io.huhu.leetcode.bit.manipulation.easy.n762;

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
    void countPrimeSetBits1() {
        Assertions.assertEquals(4, solution.countPrimeSetBits(6, 10));
    }

    @Test
    void countPrimeSetBits2() {
        Assertions.assertEquals(5, solution.countPrimeSetBits(10, 15));
    }

}
