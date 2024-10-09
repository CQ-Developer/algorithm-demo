package io.huhu.leetcode.n357;

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
        Assertions.assertEquals(91, code.countNumbersWithUniqueDigits(2));
    }

    @Test
    void test_2() {
        Assertions.assertEquals(1, code.countNumbersWithUniqueDigits(0));
    }

}
