package io.huhu.leetcode.back.trace.n2767;

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
        Assertions.assertEquals(2, solution.minimumBeautifulSubstrings("1011"));
    }

    @Test
    void case_2() {
        Assertions.assertEquals(3, solution.minimumBeautifulSubstrings("111"));
    }

    @Test
    void case_3() {
        Assertions.assertEquals(-1, solution.minimumBeautifulSubstrings("0"));
    }

}
