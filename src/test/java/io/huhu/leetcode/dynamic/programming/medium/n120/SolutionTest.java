package io.huhu.leetcode.dynamic.programming.medium.n120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3));
        Assertions.assertEquals(11, solution.minimumTotal(triangle));
    }

    @Test
    void test_2() {
        List<List<Integer>> triangle = List.of(List.of(-10));
        Assertions.assertEquals(-10, solution.minimumTotal(triangle));
    }

}
