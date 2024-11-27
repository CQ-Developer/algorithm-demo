package io.huhu.leetcode.n1621;

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
    void test(int n, int k, int ans) {
        assertEquals(ans, code.numberOfSets(n, k));
    }

    static Stream<Arguments> params() {
        return Stream.of(arguments(4, 2, 5), arguments(3, 1, 3), arguments(30, 7, 796297179), arguments(5, 3, 7));
    }

}