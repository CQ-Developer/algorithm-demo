package io.huhu.leetcode.n241;

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
        Assertions.assertIterableEquals(List.of(0, 2), code.diffWaysToCompute("2-1-1"));
    }

    @Test
    void test_2() {
        Assertions.assertIterableEquals(List.of(-34, -14, -10, -10, 10), code.diffWaysToCompute("2*3-4*5"));
    }

}
