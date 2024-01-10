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

    @Test
    void addBinary_3() {
        Assertions.assertEquals("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000", solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

}
