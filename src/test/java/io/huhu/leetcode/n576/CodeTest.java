package io.huhu.leetcode.n576;

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
        Assertions.assertEquals(6, code.findPaths(2, 2, 2, 0, 0));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(12, code.findPaths(1, 3, 3, 0, 1));
    }

}
