package io.huhu.leetcode.n464;

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
        Assertions.assertFalse(code.canIWin(10, 11));
    }

    @Test
    void test_2() {
        Assertions.assertTrue(code.canIWin(10, 0));
    }

    @Test
    void test_3() {
        Assertions.assertTrue(code.canIWin(10, 1));
    }

}