package io.huhu.leetcode.back.trace.n1986;

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
        int[] tasks = {1, 2, 3};
        int sessionTime = 3;
        Assertions.assertEquals(2, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_2() {
        int[] tasks = {3, 1, 3, 1, 1};
        int sessionTime = 8;
        Assertions.assertEquals(2, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_3() {
        int[] tasks = {1, 2, 3, 4, 5};
        int sessionTime = 15;
        Assertions.assertEquals(1, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_4() {
        int[] tasks = {3, 9};
        int sessionTime = 10;
        Assertions.assertEquals(2, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_5() {
        int[] tasks = {2, 3, 3, 4, 4, 4, 5, 6, 7, 10};
        int sessionTime = 12;
        Assertions.assertEquals(4, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_6() {
        int[] tasks = {9, 3, 4};
        int sessionTime = 10;
        Assertions.assertEquals(2, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_7() {
        int[] tasks = {1, 1, 2, 2, 2, 2, 3, 3, 6, 6, 6, 6};
        int sessionTime = 10;
        Assertions.assertEquals(4, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_8() {
        int[] tasks = {1, 2, 2, 6, 3, 5, 5, 10, 4, 10, 1, 10, 3, 7};
        int sessionTime = 13;
        Assertions.assertEquals(6, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_9() {
        int[] tasks = {9, 8, 8, 10, 10, 8, 10, 4, 8, 9, 9, 3, 10};
        int sessionTime = 15;
        Assertions.assertEquals(11, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_10() {
        int[] tasks = {6, 4, 6, 6, 3, 5, 3, 6, 6, 6, 6, 6, 3, 4};
        int sessionTime = 6;
        Assertions.assertEquals(13, solution.minSessions(tasks, sessionTime));
    }

    @Test
    void case_11() {
        int[] tasks = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int sessionTime = 10;
        Assertions.assertEquals(14, solution.minSessions(tasks, sessionTime));
    }

}
