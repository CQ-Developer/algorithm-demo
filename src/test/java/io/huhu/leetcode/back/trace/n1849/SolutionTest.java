package io.huhu.leetcode.back.trace.n1849;

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
    void case_1() {
        Assertions.assertFalse(solution.splitString("1234"));
    }

    @Test
    void case_2() {
        // 05 004 3
        Assertions.assertTrue(solution.splitString("050043"));
    }

    @Test
    void case_3() {
        Assertions.assertFalse(solution.splitString("9080701"));
    }

    @Test
    void case_4() {
        // 100 099 98
        Assertions.assertTrue(solution.splitString("10009998"));
    }

}
