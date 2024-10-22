package io.huhu.leetcode.n788;

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
        Assertions.assertEquals(4, code.rotatedDigits(10));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(0, code.rotatedDigits(1));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(1, code.rotatedDigits(2));
    }

}
