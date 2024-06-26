package io.huhu.leetcode.dynamic.programming.medium.n91;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    void case_1(Solution solution) {
        assertEquals(2, solution.numDecodings("12"));
    }

    void case_2(Solution solution) {
        assertEquals(3, solution.numDecodings("226"));
    }

    void case_3(Solution solution) {
        assertEquals(0, solution.numDecodings("06"));
    }

}
