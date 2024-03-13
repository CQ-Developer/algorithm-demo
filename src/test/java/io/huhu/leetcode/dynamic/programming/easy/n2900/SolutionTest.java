package io.huhu.leetcode.dynamic.programming.easy.n2900;

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
    void test_1() {
        String[] words = {"e", "a", "b"};
        int[] groups = {0, 0, 1};
        List<String> actual = solution.getLongestSubsequence(words, groups);
        Assertions.assertIterableEquals(List.of("a", "b"), actual);
    }

    @Test
    void test_2() {
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 0, 1, 1};
        List<String> actual = solution.getLongestSubsequence(words, groups);
        Assertions.assertIterableEquals(List.of("a", "b", "d"), actual);
    }

}