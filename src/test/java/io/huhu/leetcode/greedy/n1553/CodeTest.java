package io.huhu.leetcode.greedy.n1553;

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
        Assertions.assertEquals(4, code.minDays(10));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(3, code.minDays(6));
    }

    @Test
    void test_3() {
        Assertions.assertEquals(1, code.minDays(1));
    }

    @Test
    void test_4() {
        Assertions.assertEquals(6, code.minDays(56));
    }

}
