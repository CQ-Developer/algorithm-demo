package io.huhu.leetcode.n714;

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
        int[] prices = {1, 3, 2, 8, 4, 9};
        Assertions.assertEquals(8, code.maxProfit(prices, 2));
    }

    @Test
    void test_2() {
        int[] prices = {1, 3, 7, 5, 10, 3};
        Assertions.assertEquals(6, code.maxProfit(prices, 3));
    }

}
