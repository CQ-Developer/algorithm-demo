package io.huhu.leetcode.n313;

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
        int[] primes = {2, 7, 13, 19};
        Assertions.assertEquals(32, code.nthSuperUglyNumber(12, primes));
    }

    @Test
    void test_2() {
        int[] primes = {2, 3, 5};
        Assertions.assertEquals(1, code.nthSuperUglyNumber(1, primes));
    }

}
