package io.huhu.leetcode.bit.manipulation.easy.n190;

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
    void reverseBits1() {
        Assertions.assertEquals(964176192, solution.reverseBits(43261596));
    }

    @Test
    void reverseBits2() {
        Assertions.assertEquals(-3, solution.reverseBits(-1073741825));
    }

}
