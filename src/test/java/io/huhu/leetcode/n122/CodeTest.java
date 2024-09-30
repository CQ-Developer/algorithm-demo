package io.huhu.leetcode.n122;

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
        int[] prices = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7, code.maxProfit(prices));
    }

    @Test
    void test_2() {
        int[] prices = {1, 2, 3, 4, 5};
        Assertions.assertEquals(4, code.maxProfit(prices));
    }

    @Test
    void test_3() {
        int[] prices = {7, 6, 4, 3, 1};
        Assertions.assertEquals(0, code.maxProfit(prices));
    }

}
