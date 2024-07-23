package io.huhu.leetcode.classic.other.n5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class CodeTest {

    Code code;

    @BeforeEach
    void setup() {
        code = getCode();
    }

    protected abstract Code getCode();

    @Test
    void test_1() {
        int[][] arr = {{71, 100}, {69, 1}, {1, 2}};
        Assertions.assertEquals(3, code.solution(arr, 70));
    }

    @Test
    void test_2() {
        int[][] arr = {{70, 100}, {69, 1}, {1, 2}};
        Assertions.assertEquals(100, code.solution(arr, 70));
    }

    @Test
    void test_3() {
        int[][] arr = {{70, 100}, {68, 1}, {1, 2}, {1, 100}};
        Assertions.assertEquals(103, code.solution(arr, 70));
    }

    @Test
    void test_4() {
        int[][] arr = {{69, 100}, {68, 1}, {1, 2}, {1, 100}};
        Assertions.assertEquals(200, code.solution(arr, 70));
    }

}
