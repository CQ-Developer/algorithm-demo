package io.huhu.leetcode.bit.manipulation.easy.lcr.n190;

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
    void encryptionCalculate() {
        Assertions.assertEquals(4, solution.encryptionCalculate(5, -1));
    }

}
