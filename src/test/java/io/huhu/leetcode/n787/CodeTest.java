package io.huhu.leetcode.n787;

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
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}};
        Assertions.assertEquals(700, code.findCheapestPrice(4, flights, 0, 3, 1));
    }

    @Test
    void test_2() {
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}};
        Assertions.assertEquals(200, code.findCheapestPrice(3, flights, 0, 2, 1));
    }

    @Test
    void test_3() {
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}};
        Assertions.assertEquals(500, code.findCheapestPrice(3, flights, 0, 2, 0));
    }

}
