package io.huhu.leetcode.dynamic.programming.medium.n131;

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
        List<List<String>> actual = solution.partition("aab");
        List<List<String>> expect = List.of(List.of("a", "a", "b"), List.of("aa", "b"));
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void test_2() {
        List<List<String>> actual = solution.partition("a");
        List<List<String>> expect = List.of(List.of("a"));
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void test_3() {
        List<List<String>> actual = solution.partition("efe");
        List<List<String>> expect = List.of(List.of("e", "f", "e"), List.of("efe"));
        Assertions.assertIterableEquals(expect, actual);
    }

}
