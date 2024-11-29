package io.huhu.leetcode.n1774;

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
    void test(int[] baseCosts, int[] toppingCosts, int target, int ans) {
        assertEquals(ans, code.closestCost(baseCosts, toppingCosts, target));
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{1, 7}, new int[]{3, 4}, 10, 10),
                arguments(new int[]{2, 3}, new int[]{4, 5, 100}, 18, 17),
                arguments(new int[]{3, 10}, new int[]{2, 5}, 9, 8));
    }

}