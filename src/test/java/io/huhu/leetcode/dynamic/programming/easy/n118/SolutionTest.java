package io.huhu.leetcode.dynamic.programming.easy.n118;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void generate_1() {
        List<List<Integer>> expected = List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1));
        Assertions.assertEquals(expected, solution.generate(5));
    }

    @Test
    void generate_2() {
        List<List<Integer>> expected = List.of(List.of(1));
        Assertions.assertEquals(expected, solution.generate(1));
    }

    @Test
    void generate_3() {
        List<List<Integer>> expected = List.of(List.of(1), List.of(1, 1));
        Assertions.assertEquals(expected, solution.generate(2));
    }

}
