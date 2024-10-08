package io.huhu.leetcode.n343;

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
        Assertions.assertEquals(1, code.integerBreak(2));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(36, code.integerBreak(10));
    }

}
