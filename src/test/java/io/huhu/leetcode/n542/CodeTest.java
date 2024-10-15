package io.huhu.leetcode.n542;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

abstract class CodeTest {

    Code code;

    abstract Code getCode();

    @BeforeEach
    void setup() {
        code = getCode();
    }

    @Test
    void test_1() {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int[][] expect = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        Assertions.assertTrue(Arrays.deepEquals(code.updateMatrix(mat), expect));
    }

    @Test
    void test_2() {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        int[][] expect = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}};
        Assertions.assertTrue(Arrays.deepEquals(code.updateMatrix(mat), expect));
    }
}