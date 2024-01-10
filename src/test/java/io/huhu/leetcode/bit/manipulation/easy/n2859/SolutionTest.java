package io.huhu.leetcode.bit.manipulation.easy.n2859;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void sumIndicesWithKSetBits_1() {
        Assertions.assertEquals(13, solution.sumIndicesWithKSetBits(List.of(5, 10, 1, 5, 2), 1));
    }

    @Test
    void sumIndicesWithKSetBits_2() {
        Assertions.assertEquals(1, solution.sumIndicesWithKSetBits(List.of(4, 3, 2, 1), 2));
    }

}
