package io.huhu.leetcode.back.trace.n2048;

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
        Assertions.assertEquals(22, solution.nextBeautifulNumber(1));
    }

    @Test
    void case_2() {
        Assertions.assertEquals(1333, solution.nextBeautifulNumber(1000));
    }

    @Test
    void case_3() {
        Assertions.assertEquals(3133, solution.nextBeautifulNumber(3000));
    }

}
