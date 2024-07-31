package io.huhu.leetcode.dynamic.programming.hard.n2218;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = getSolution();
    }

    protected abstract Solution getSolution();

    @Test
    void test_1() {
        List<List<Integer>> piles = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 100, 3)),
                new ArrayList<>(List.of(7, 8, 9))));
        Assertions.assertEquals(101, solution.maxValueOfCoins(piles, 2));
    }

    @Test
    void test_2() {
        List<List<Integer>> piles = new ArrayList<>(List.of(
                new ArrayList<>(List.of(100)),
                new ArrayList<>(List.of(100)),
                new ArrayList<>(List.of(100)),
                new ArrayList<>(List.of(100)),
                new ArrayList<>(List.of(100)),
                new ArrayList<>(List.of(100)),
                new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 700))));
        Assertions.assertEquals(706, solution.maxValueOfCoins(piles, 7));
    }

}
