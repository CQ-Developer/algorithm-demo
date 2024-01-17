package io.huhu.leetcode.dynamic.programming.easy.n392;

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
    void isSubsequence_1() {
        Assertions.assertTrue(solution.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    void isSubsequence_2() {
        Assertions.assertFalse(solution.isSubsequence("axc", "ahbgdc"));
    }

}
