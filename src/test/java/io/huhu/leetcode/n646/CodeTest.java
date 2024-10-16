package io.huhu.leetcode.n646;

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
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        Assertions.assertEquals(2, code.findLongestChain(pairs));
    }

    @Test
    void test_2() {
        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        Assertions.assertEquals(3, code.findLongestChain(pairs));
    }

}
