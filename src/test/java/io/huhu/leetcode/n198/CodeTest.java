package io.huhu.leetcode.n198;

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
        int[] nnums = {1, 2, 3, 1};
        Assertions.assertEquals(4, code.rob(nnums));
    }

    @Test
    void test_2() {
        int[] nnums = {2, 7, 9, 3, 1};
        Assertions.assertEquals(12, code.rob(nnums));
    }

}
