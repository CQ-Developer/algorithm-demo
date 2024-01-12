package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n01;

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
    void insertBits_1() {
        Assertions.assertEquals(1100, solution.insertBits(1024, 19, 2, 6));
    }

    @Test
    void insertBits_2() {
        Assertions.assertEquals(31, solution.insertBits(0, 31, 0, 4));
    }

    @Test
    void insertBits_3() {
        Assertions.assertEquals(2082885133, solution.insertBits(1143207437, 1017033, 11, 31));
    }

}
