package io.huhu.leetcode.bit.manipulation.easy.lcr.n002;

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
    void addBinary_1() {
        Assertions.assertEquals("101", solution.addBinary("11", "10"));
    }

    @Test
    void addBinary_2() {
        Assertions.assertEquals("10101", solution.addBinary("1010", "1011"));
    }

}
