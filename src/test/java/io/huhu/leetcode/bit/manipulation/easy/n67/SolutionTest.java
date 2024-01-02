package io.huhu.leetcode.bit.manipulation.easy.n67;

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
    void addBinary1() {
        Assertions.assertEquals("100", solution.addBinary("11", "1"));
    }

    @Test
    void addBinary2() {
        Assertions.assertEquals("10101", solution.addBinary("1010", "1011"));
    }

}
