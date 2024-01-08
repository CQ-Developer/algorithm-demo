package io.huhu.leetcode.bit.manipulation.easy.n868;

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
    void binaryGap1() {
        Assertions.assertEquals(2, solution.binaryGap(22));
    }

    @Test
    void binaryGap2() {
        Assertions.assertEquals(0, solution.binaryGap(8));
    }

    @Test
    void binaryGap3() {
        Assertions.assertEquals(2, solution.binaryGap(5));
    }

}
