package io.huhu.leetcode.n1626;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(int[] scores, int[] ages, int ans) {
        assertEquals(ans, code.bestTeamScore(scores, ages));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}, 34),
                arguments(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}, 16),
                arguments(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}, 6));
    }

}