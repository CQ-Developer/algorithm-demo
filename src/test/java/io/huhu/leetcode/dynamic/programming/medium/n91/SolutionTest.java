package io.huhu.leetcode.dynamic.programming.medium.n91;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        assertEquals(2, solution.numDecodings("12"));
    }

    @Test
    void test_2() {
        assertEquals(3, solution.numDecodings("226"));
    }

    @Test
    void test_3() {
        assertEquals(0, solution.numDecodings("06"));
    }

}
