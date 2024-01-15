package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n06;

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
    void convertInteger_1() {
        Assertions.assertEquals(2, solution.convertInteger(29, 15));
    }

    @Test
    void convertInteger_2() {
        Assertions.assertEquals(2, solution.convertInteger(1, 2));
    }

}
