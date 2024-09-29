package io.huhu.leetcode.n64;

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
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Assertions.assertEquals(7, code.minPathSum(grid));
    }

    @Test
    void test_2() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        Assertions.assertEquals(12, code.minPathSum(grid));
    }

}
