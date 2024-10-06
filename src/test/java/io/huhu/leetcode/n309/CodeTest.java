package io.huhu.leetcode.n309;

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
        int[] prices = {1, 2, 3, 0, 2};
        Assertions.assertEquals(3, code.maxProfit(prices));
    }

    @Test
    void test_2() {
        int[] prices = {1};
        Assertions.assertEquals(0, code.maxProfit(prices));
    }

}
