package io.huhu.leetcode.n790;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    abstract Code code();

    @BeforeEach
    void setup() {
        code = code();
    }

    @Test
    void test_1() {
        Assertions.assertEquals(5, code.numTilings(3));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(1, code.numTilings(1));
    }

}
