package io.huhu.leetcode.back.trace.interview.questions.n08.n09;

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
    void case_1() {
        List<String> actual = solution.generateParenthesis(3);
        List<String> expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void case_2() {
        List<String> actual = solution.generateParenthesis(5);
        List<String> expected = List.of(
                "((((()))))", "(((()())))", "(((())()))", "(((()))())", "(((())))()",
                "((()(())))", "((()()()))", "((()())())", "((()()))()", "((())(()))",
                "((())()())", "((())())()", "((()))(())", "((()))()()", "(()((())))",
                "(()(()()))", "(()(())())", "(()(()))()", "(()()(()))", "(()()()())",
                "(()()())()", "(()())(())", "(()())()()", "(())((()))", "(())(()())",
                "(())(())()", "(())()(())", "(())()()()", "()(((())))", "()((()()))",
                "()((())())", "()((()))()", "()(()(()))", "()(()()())", "()(()())()",
                "()(())(())", "()(())()()", "()()((()))", "()()(()())", "()()(())()",
                "()()()(())", "()()()()()");
        Assertions.assertIterableEquals(expected, actual);
    }

}
