package io.huhu.leetcode.n435;

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
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Assertions.assertEquals(1, code.eraseOverlapIntervals(intervals));
    }

    @Test
    void test_2() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        Assertions.assertEquals(2, code.eraseOverlapIntervals(intervals));
    }

    @Test
    void test_3() {
        int[][] intervals = {{1, 2}, {2, 3}};
        Assertions.assertEquals(0, code.eraseOverlapIntervals(intervals));
    }

}
