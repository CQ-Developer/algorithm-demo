package io.huhu.leetcode.bit.manipulation.easy.interview.n17.n01;

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
    void add_1() {
        Assertions.assertEquals(2, solution.add(1, 1));
    }

    @Test
    void add_2() {
        Assertions.assertEquals(3, solution.add(1, 2));
    }

    @Test
    void add_3() {
        Assertions.assertEquals(-3, solution.add(-1, -2));
    }

}
