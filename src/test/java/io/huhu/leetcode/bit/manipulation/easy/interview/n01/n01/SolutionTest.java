package io.huhu.leetcode.bit.manipulation.easy.interview.n01.n01;

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
    void isUnique_1() {
        Assertions.assertFalse(solution.isUnique("leetcode"));
    }

    @Test
    void isUnique_2() {
        Assertions.assertTrue(solution.isUnique("abc"));
    }

}
