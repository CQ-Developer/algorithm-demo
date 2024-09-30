package io.huhu.leetcode.n120;

import java.util.List;

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
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        Assertions.assertEquals(11, code.minimumTotal(triangle));
    }

    @Test
    void test_2() {
        List<List<Integer>> triangle = List.of(List.of(-10));
        Assertions.assertEquals(-10, code.minimumTotal(triangle));
    }

}
