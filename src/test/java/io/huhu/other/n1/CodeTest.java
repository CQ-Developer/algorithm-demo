package io.huhu.other.n1;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

abstract class CodeTest {

    Code code;
    Validator validator;

    abstract Code code();

    @BeforeEach
    void setup() {
        code = code();
        validator = new Validator();
    }

    @ParameterizedTest
    @MethodSource("generator")
    void test_1(int n, int k) {
        Assertions.assertEquals(validator.max(n, k), code.max(n, k));
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.arguments(3, 2),
                Arguments.arguments(10, 3),
                Arguments.arguments(10, 4),
                Arguments.arguments(41, 8));
    }

}
