package io.huhu.leetcode.n221;

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
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Assertions.assertEquals(4, code.maximalSquare(matrix));
    }

    @Test
    void test_2() {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        Assertions.assertEquals(1, code.maximalSquare(matrix));
    }

    @Test
    void test_3() {
        char[][] matrix = {{'0'}};
        Assertions.assertEquals(0, code.maximalSquare(matrix));
    }

}
