package io.huhu.leetcode.n85;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void maximalRectangle1() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        Assertions.assertEquals(6, solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle2() {
        // 条件说明矩阵的长宽最小为1，所以代码中并没有判断空矩阵的情况
        char[][] matrix = {};
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle3() {
        char[][] matrix = {{'0'}};
        Assertions.assertEquals(0, solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle4() {
        char[][] matrix = {{'1'}};
        Assertions.assertEquals(1, solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle5() {
        char[][] matrix = {{'0', '0'}};
        Assertions.assertEquals(0, solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle6() {
        char[][] matrix = {{'0', '1'}};
        Assertions.assertEquals(1, solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle7() {
        char[][] matrix = {
                {'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'}};
        Assertions.assertEquals(21, solution.maximalRectangle(matrix));
    }

    @Test
    void maximalRectangle8() {
        char[][] matrix = {
                {'0', '1'},
                {'1', '0'}};
        Assertions.assertEquals(1, solution.maximalRectangle(matrix));
    }

}
