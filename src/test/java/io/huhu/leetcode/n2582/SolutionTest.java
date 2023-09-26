package io.huhu.leetcode.n2582;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void passThePillow_1() {
        assertEquals(2, solution.passThePillow(4, 5));
    }

    @Test
    void passThePillow_2() {
        assertEquals(3, solution.passThePillow(3, 2));
    }

    @Test
    void passThePillow_3() {
        assertEquals(79, solution.passThePillow(333, 586));
    }

}
