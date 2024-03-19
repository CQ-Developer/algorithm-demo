package io.huhu.leetcode.dynamic.programming.easy.interview.n08.n01;

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
        assertEquals(4, solution.waysToStep(3));
    }

    @Test
    void test_2() {
        assertEquals(7, solution.waysToStep(4));
    }

    @Test
    void test_3() {
        assertEquals(13, solution.waysToStep(5));
    }

    @Test
    void test_4() {
        assertEquals(24, solution.waysToStep(6));
    }

    @Test
    void test_5() {
        assertEquals(44, solution.waysToStep(7));
    }

    @Test
    void test_6() {
        assertEquals(81, solution.waysToStep(8));
    }

    @Test
    void test_7() {
        assertEquals(149, solution.waysToStep(9));
    }

    @Test
    void test_8() {
        assertEquals(274, solution.waysToStep(10));
    }

    @Test
    void test_9() {
        assertEquals(504, solution.waysToStep(11));
    }

    @Test
    void test_10() {
        assertEquals(746580045, solution.waysToStep(1000000));
    }

}
