package io.huhu.leetcode.back.trace.n301;

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
    void removeInvalidParentheses1() {
        List<String> actual = solution.removeInvalidParentheses("()())()");
        List<String> expect = List.of("(())()", "()()()");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses2() {
        List<String> actual = solution.removeInvalidParentheses("(a)())()");
        List<String> expect = List.of("(a())()", "(a)()()");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses3() {
        List<String> actual = solution.removeInvalidParentheses(")(");
        List<String> expect = List.of("");
        Assertions.assertIterableEquals(expect, actual);
    }

}