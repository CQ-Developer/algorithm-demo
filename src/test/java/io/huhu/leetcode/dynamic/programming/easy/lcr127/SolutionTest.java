package io.huhu.leetcode.dynamic.programming.easy.lcr127;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        assertEquals(2, solution.trainWays(2));
    }

    @Test
    void test_2() {
        assertEquals(8, solution.trainWays(5));
    }

    @Test
    void test_3() {
        assertEquals(782204094, solution.trainWays(100));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void test_4(int num) {
        assertEquals(1, solution.trainWays(num));
    }

}
