package io.huhu.leetcode.n688;

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
        Assertions.assertEquals(0.0625, code.knightProbability(3, 2, 0, 0));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(1.0, code.knightProbability(1, 0, 0, 0));
    }

}