package io.huhu.leetcode.back.trace.n2698;

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
        Assertions.assertEquals(182, solution.punishmentNumber(10));
    }

    @Test
    void case_2() {
        Assertions.assertEquals(1478, solution.punishmentNumber(37));
    }

    @Test
    void case_3() {
        Assertions.assertEquals(10804657, solution.punishmentNumber(1000));
    }

    @Test
    void case_4() {
        Assertions.assertEquals(1, solution.punishmentNumber(1));
    }

    @Test
    void case_5() {
        Assertions.assertEquals(772866, solution.punishmentNumber(500));
    }

}
