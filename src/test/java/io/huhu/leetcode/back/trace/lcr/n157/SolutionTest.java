package io.huhu.leetcode.back.trace.lcr.n157;

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
        String[] actual = solution.goodsOrder("agew");
        String[] expected = {"aegw", "aewg", "agew",
                             "agwe", "aweg", "awge",
                             "eagw", "eawg", "egaw",
                             "egwa", "ewag", "ewga",
                             "gaew", "gawe", "geaw",
                             "gewa", "gwae", "gwea",
                             "waeg", "wage", "weag",
                             "wega", "wgae", "wgea"};
        Assertions.assertArrayEquals(expected, actual);
    }

}
