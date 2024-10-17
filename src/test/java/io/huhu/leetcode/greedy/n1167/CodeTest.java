package io.huhu.leetcode.greedy.n1167;

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
        int[] sticks = {2, 4, 3};
        Assertions.assertEquals(14, code.connectSticks(sticks));
    }

}