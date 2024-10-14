package io.huhu.leetcode.n518;

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
        int[] coins = {1, 2, 5};
        Assertions.assertEquals(4, code.change(5, coins));
    }

    @Test
    void test_2() {
        int[] coins = {2};
        Assertions.assertEquals(0, code.change(3, coins));
    }

    @Test
    void test_3() {
        int[] coins = {10};
        Assertions.assertEquals(1, code.change(10, coins));
    }

}
