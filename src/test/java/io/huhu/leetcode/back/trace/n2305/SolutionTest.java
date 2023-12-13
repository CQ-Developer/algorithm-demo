package io.huhu.leetcode.back.trace.n2305;

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
        int[] cookies = {8, 15, 10, 20, 8};
        int k = 2;
        Assertions.assertEquals(31, solution.distributeCookies(cookies, k));
    }

    @Test
    void case_2() {
        int[] cookies = {6, 1, 3, 2, 2, 4, 1, 2};
        int k = 3;
        Assertions.assertEquals(7, solution.distributeCookies(cookies, k));
    }

}
