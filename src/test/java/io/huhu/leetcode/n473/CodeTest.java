package io.huhu.leetcode.n473;

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
        int[] matchsticks = {1, 1, 2, 2, 2};
        Assertions.assertTrue(code.makesquare(matchsticks));
    }

    @Test
    void test_2() {
        int[] matchsticks = {3, 3, 3, 3, 4};
        Assertions.assertFalse(code.makesquare(matchsticks));
    }

}