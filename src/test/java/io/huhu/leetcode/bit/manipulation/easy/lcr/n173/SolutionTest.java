package io.huhu.leetcode.bit.manipulation.easy.lcr.n173;

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
    void takeAttendance_1() {
        int[] records = {0, 1, 2, 3, 5};
        Assertions.assertEquals(4, solution.takeAttendance(records));
    }

    @Test
    void takeAttendance_2() {
        int[] records = {0, 1, 2, 3, 4, 5, 6, 8};
        Assertions.assertEquals(7, solution.takeAttendance(records));
    }

    @Test
    void takeAttendance_3() {
        int[] records = {0};
        Assertions.assertEquals(1, solution.takeAttendance(records));
    }

}
