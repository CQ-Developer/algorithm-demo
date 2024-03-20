package io.huhu.leetcode.dynamic.programming.medium.n22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        List<String> expected = List.of("()");
        assertIterableEquals(expected, solution.generateParenthesis(1));
    }

    @Test
    void test_2() {
        List<String> expected = List.of("()()()", "()(())", "(()())", "(())()", "((()))");
        assertIterableEquals(expected, solution.generateParenthesis(3));
    }

    @Test
    void test_3() {
        List<String> expected = List.of(
                "()()()()", "(()(()))", "(()())()", "()()(())",
                "(())()()", "(((())))", "(())(())", "()((()))",
                "()(())()", "()(()())", "(()()())", "((()()))",
                "((()))()", "((())())");
        assertIterableEquals(expected, solution.generateParenthesis(4));
    }

}
