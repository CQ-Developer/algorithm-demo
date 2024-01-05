package io.huhu.leetcode.bit.manipulation.easy.n461;

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
    void hammingDistance1() {
        Assertions.assertEquals(2, solution.hammingDistance(1, 4));
    }

    @Test
    void hammingDistance2() {
        Assertions.assertEquals(1, solution.hammingDistance(3, 1));
    }

}
