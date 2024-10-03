package io.huhu.leetcode.n264;

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
        Assertions.assertEquals(12, code.nthUglyNumber(10));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(1, code.nthUglyNumber(1));
    }

}
