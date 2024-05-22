package io.huhu.leetcode.dynamic.programming.medium.n221;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'}};
        Assertions.assertEquals(4, solution.maximalSquare(matrix));
    }

    @Test
    void test_2() {
        char[][] matrix = {
                {'0', '1'},
                {'1', '0'}};
        Assertions.assertEquals(1, solution.maximalSquare(matrix));
    }

    @Test
    void test_3() {
        char[][] matrix = {{'0'}};
        Assertions.assertEquals(0, solution.maximalSquare(matrix));
    }

}