package io.huhu.leetcode.n131;

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
        List<List<String>> expected = List.of(
                List.of("a", "a", "b"),
                List.of("aa", "b"));
        Assertions.assertIterableEquals(expected, code.partition("aab"));
    }

    @Test
    void test_2() {
        List<List<String>> expected = List.of(List.of("a"));
        Assertions.assertIterableEquals(expected, code.partition("a"));
    }

}
