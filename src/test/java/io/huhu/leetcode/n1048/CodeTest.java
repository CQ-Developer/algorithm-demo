package io.huhu.leetcode.n1048;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("templates")
    void test(String[] words, int expected) {
        Assertions.assertEquals(expected, code.longestStrChain(words));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4),
                Arguments.arguments(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5),
                Arguments.arguments(new String[]{"abcd", "dbqca"}, 1));
    }

}