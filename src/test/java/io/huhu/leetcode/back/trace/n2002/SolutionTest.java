package io.huhu.leetcode.back.trace.n2002;

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
    void case_1() {
        Assertions.assertEquals(9, solution.maxProduct("leetcodecom"));
    }

    @Test
    void case_2() {
        Assertions.assertEquals(1, solution.maxProduct("bb"));
    }

    @Test
    void case_3() {
        Assertions.assertEquals(25, solution.maxProduct("accbcaxxcxx"));
    }

}
