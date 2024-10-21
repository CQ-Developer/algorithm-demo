package io.huhu.leetcode.n764;

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
        int[][] mines = {{4, 2}};
        Assertions.assertEquals(2, code.orderOfLargestPlusSign(5, mines));
    }

    @Test
    void test_2() {
        int[][] mines = {{0, 0}};
        Assertions.assertEquals(0, code.orderOfLargestPlusSign(1, mines));
    }

}
