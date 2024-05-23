package io.huhu.leetcode.dynamic.programming.medium.n241;

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
        List<Integer> expected = List.of(0, 2);
        List<Integer> actual = solution.diffWaysToCompute("2-1-1");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    void test_2() {
        List<Integer> expected = List.of(-34, -14, -10, -10, 10);
        List<Integer> actual = solution.diffWaysToCompute("2*3-4*5");
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

}