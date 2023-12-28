package io.huhu.leetcode.back.trace.n301;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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
        List<String> expect = new ArrayList<>(List.of("(())()", "()()()"));
        Collections.sort(actual);
        Collections.sort(expect);
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses2() {
        List<String> actual = solution.removeInvalidParentheses("(a)())()");
        List<String> expect = new ArrayList<>(List.of("(a())()", "(a)()()"));
        Collections.sort(actual);
        Collections.sort(expect);
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses3() {
        List<String> actual = solution.removeInvalidParentheses(")(");
        List<String> expect = List.of("");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses4() {
        List<String> actual = solution.removeInvalidParentheses("x(");
        List<String> expect = List.of("x");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses5() {
        List<String> actual = solution.removeInvalidParentheses("(()");
        List<String> expect = List.of("()");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses6() {
        List<String> actual = solution.removeInvalidParentheses(")d))");
        List<String> expect = List.of("d");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses7() {
        List<String> actual = solution.removeInvalidParentheses("))()((");
        List<String> expect = List.of("()");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses8() {
        List<String> actual = solution.removeInvalidParentheses("(");
        List<String> expect = List.of("");
        Assertions.assertIterableEquals(expect, actual);
    }

    @Test
    void removeInvalidParentheses9() {
        List<String> actual = solution.removeInvalidParentheses(")t))()()bo)");
        List<String> expect = new ArrayList<>(List.of("t(()bo)", "t()(bo)", "t()()bo"));
        Collections.sort(actual);
        Collections.sort(expect);
        Assertions.assertIterableEquals(expect, actual);
    }

}
