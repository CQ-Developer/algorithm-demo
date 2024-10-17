package io.huhu.leetcode.greedy.n630;

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
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        Assertions.assertEquals(3, code.scheduleCourse(courses));
    }

    @Test
    void test_2() {
        int[][] courses = {{1, 2}};
        Assertions.assertEquals(1, code.scheduleCourse(courses));
    }

    @Test
    void test_3() {
        int[][] courses = {{3, 2}, {4, 3}};
        Assertions.assertEquals(0, code.scheduleCourse(courses));
    }

}