package io.huhu.leetcode.n1997;

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
    void test(int[] nextVisit, int res) {
        assertEquals(res, code.firstDayBeenInAllRooms(nextVisit));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{0, 0}, 2),
                arguments(new int[]{0, 0, 2}, 6),
                arguments(new int[]{0, 1, 2, 0}, 6));
    }

}