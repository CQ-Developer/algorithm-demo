package io.huhu.leetcode.back.trace.n22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void generateParenthesis_1() {
        var expect = List.of("()");
        Assertions.assertIterableEquals(expect, solution.generateParenthesis(1));
    }

    @Test
    void generateParenthesis_2() {
        var expect = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        Assertions.assertIterableEquals(expect, solution.generateParenthesis(3));
    }

}
