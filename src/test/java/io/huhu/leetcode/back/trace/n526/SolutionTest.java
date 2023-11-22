package io.huhu.leetcode.back.trace.n526;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @Test
    void countArrangement_1() {
        assertEquals(1, solution.countArrangement(1));
    }

    @Test
    void countArrangement_2() {
        assertEquals(2, solution.countArrangement(2));
    }

    @Test
    void countArrangement_3() {
        assertEquals(3, solution.countArrangement(3));
    }

    @Test
    void countArrangement_4() {
        assertEquals(8, solution.countArrangement(4));
    }

    @Test
    void countArrangement_5() {
        assertEquals(10, solution.countArrangement(5));
    }

    @Test
    void countArrangement_6() {
        assertEquals(36, solution.countArrangement(6));
    }

    @Test
    void countArrangement_15() {
        assertEquals(24679, solution.countArrangement(15));
    }

}
