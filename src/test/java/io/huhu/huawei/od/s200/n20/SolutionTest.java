package io.huhu.huawei.od.s200.n20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test1() {
        int[][] times = {{1, 4}, {2, 5}, {7, 9}, {14, 18}};
        int[][] actual = solution.mergeMeetingTimes(times);
        int[][] expected = {{1, 5}, {7, 9}, {14, 18}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    void test2() {
        int[][] times = {{1, 4}, {4, 5}};
        int[][] actual = solution.mergeMeetingTimes(times);
        int[][] expected = {{1, 5}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    void test3() {
        int[][] times = {{1, 4}, {8, 11}, {4, 5}, {3, 6}, {5, 6}};
        int[][] actual = solution.mergeMeetingTimes(times);
        int[][] expected = {{1, 6}, {8, 11}};
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

}
