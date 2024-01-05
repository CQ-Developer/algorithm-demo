package io.huhu.leetcode.bit.manipulation.easy.n405;

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
    void toHex1() {
        Assertions.assertEquals("1a", solution.toHex(26));
    }

    @Test
    void toHex2() {
        Assertions.assertEquals("ffffffff", solution.toHex(-1));
    }

    @Test
    void toHex3() {
        Assertions.assertEquals("0", solution.toHex(0));
    }

}
