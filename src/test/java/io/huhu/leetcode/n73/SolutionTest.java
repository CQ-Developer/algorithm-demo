package io.huhu.leetcode.n73;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void setZeroes_1() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        solution.setZeroes(matrix);
        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};
        assertTrue(Arrays.deepEquals(expected, matrix));
    }

    @Test
    void setZeroes_2() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        solution.setZeroes(matrix);
        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};
        assertTrue(Arrays.deepEquals(expected, matrix));
    }

    @Test
    void setZeroes_3() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        int[][] expected = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}};
        assertTrue(Arrays.deepEquals(expected, matrix));
    }

    @Test
    void setZeroes_4() {
        int[][] matrix = {
                {-1},
                {2},
                {3}};
        solution.setZeroes(matrix);
        int[][] expected = {
                {-1},
                {2},
                {3}};
        assertTrue(Arrays.deepEquals(expected, matrix));
    }

}