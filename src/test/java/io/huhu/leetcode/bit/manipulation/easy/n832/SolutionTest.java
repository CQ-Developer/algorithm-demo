package io.huhu.leetcode.bit.manipulation.easy.n832;

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
    void flipAndInvertImage1() {
        int[][] image = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}};
        int[][] expect = {
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        Assertions.assertArrayEquals(expect, solution.flipAndInvertImage(image));
    }

    @Test
    void flipAndInvertImage2() {
        int[][] image = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}};
        int[][] expect = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 1, 0}};
        Assertions.assertArrayEquals(expect, solution.flipAndInvertImage(image));
    }

}
