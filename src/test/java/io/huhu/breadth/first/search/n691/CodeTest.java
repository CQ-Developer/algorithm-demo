package io.huhu.breadth.first.search.n691;

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
    @MethodSource("cases")
    void test(String[] stickers, String target, int ans) {
        Assertions.assertEquals(ans, code.minStickers(stickers, target));
    }

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.arguments(new String[]{"with", "example", "science"}, "thehat", 3),
                Arguments.arguments(new String[]{"notic", "possible"}, "basicbasic", -1));
    }

}