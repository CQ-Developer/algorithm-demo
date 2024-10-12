package io.huhu.leetcode.n467;

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
        Assertions.assertEquals(1, code.findSubstringInWraproundString("a"));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(2, code.findSubstringInWraproundString("cac"));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(6, code.findSubstringInWraproundString("zab"));
    }

}
