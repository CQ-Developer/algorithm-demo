package io.huhu.leetcode.n63;

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
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Assertions.assertEquals(2, code.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    void test_2() {
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        Assertions.assertEquals(1, code.uniquePathsWithObstacles(obstacleGrid));
    }

}
