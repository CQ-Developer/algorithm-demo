package io.huhu.leetcode.dynamic.programming.hard.n1434;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        var hats = List.of(List.of(3, 4), List.of(4, 5), List.of(5));
        Assertions.assertEquals(1, solution.numberWays(hats));
    }

    @Test
    void test_2() {
        var hats = List.of(List.of(3, 5, 1), List.of(3, 5));
        Assertions.assertEquals(4, solution.numberWays(hats));
    }

    @Test
    void test_3() {
        var hats = List.of(List.of(1, 2, 3, 4), List.of(1, 2, 3, 4), List.of(1, 2, 3, 4), List.of(1, 2, 3, 4));
        Assertions.assertEquals(24, solution.numberWays(hats));
    }

}
