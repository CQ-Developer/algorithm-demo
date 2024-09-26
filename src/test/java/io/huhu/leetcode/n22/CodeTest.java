package io.huhu.leetcode.n22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        List<String> expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        expected = new ArrayList<>(expected);
        List<String> actual = code.generateParenthesis(3);
        Collections.sort(expected, String::compareTo);
        Collections.sort(actual, String::compareTo);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void test_2() {
        List<String> expected = List.of("()");
        expected = new ArrayList<>(expected);
        List<String> actual = code.generateParenthesis(1);
        Collections.sort(expected, String::compareTo);
        Collections.sort(actual, String::compareTo);
        Assertions.assertIterableEquals(expected, actual);
    }

}
