package io.huhu.leetcode.bit.manipulation.easy.n191;

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
    void hammingWeight1() {
        Assertions.assertEquals(3, solution.hammingWeight(11));
    }

    @Test
    void hammingWeight2() {
        Assertions.assertEquals(1, solution.hammingWeight(128));
    }

    @Test
    void hammingWeight3() {
        Assertions.assertEquals(31, solution.hammingWeight(-3));
    }

}
