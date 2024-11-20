package io.huhu.leetcode.n1334;

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
    @MethodSource("template")
    void test(int n, int[][] edges, int distanceThreshold, int ans) {
        assertEquals(ans, code.findTheCity(n, edges, distanceThreshold));
    }

    static Stream<Arguments> template() {
        return Stream.of(
                arguments(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4, 3),
                arguments(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2, 0));
    }

}