package io.huhu.leetcode.n1105;

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
    void test(int[][] books, int shelfWidth, int expected) {
        Assertions.assertEquals(expected, code.minHeightShelves(books, shelfWidth));
    }

    static Stream<Arguments> templates() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4, 6),
                Arguments.arguments(new int[][]{{1, 3}, {2, 4}, {3, 2}}, 6, 4));
    }

}